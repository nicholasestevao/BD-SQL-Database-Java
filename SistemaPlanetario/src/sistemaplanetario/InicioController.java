
package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class InicioController implements Initializable {

    @FXML
    private Button bMissoes;
    
    @FXML
    private Button bPlanetas;
    
    @FXML
    private Button bRotas;

    private Conexao conexao;

    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            System.out.println("Obtendo conexão...");
            if(conexao == null){
                Stage stage = (Stage) bMissoes.getScene().getWindow();
                conexao = (Conexao) stage.getUserData();

                if(conexao == null)
                    return;

                conexao.imprimeConexao();
                System.out.println(conexao.retornaConexao());
                
                verificaConexaoThread.start();
                this.stop();
            }
            else
                conexao = null;
            
        }
    };

    private AnimationTimer verificaConexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                if(!conexao.estaConectado()){
                    System.out.println("Você foi desconectado!");

                    Stage stage = (Stage)bMissoes.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("Login");
                    stage.setScene(scene);
                    stage.show();
                    this.stop();
                }
            }
            catch(SQLException s){
                System.out.println(s.getSQLState());
            }
            catch(IOException e){
                System.out.println("Não foi possível gerar a tela de Login.");
                e.printStackTrace();
            }
            catch(Exception ex){
                System.out.println("aa");
            }
            
        }
    };
    
    @FXML
    private void consultarMissoes(ActionEvent event) {
        System.out.println("Consultar missoes");
        try{
            Stage stage = (Stage) bMissoes.getScene().getWindow();
            stage.setTitle("Consultar missões");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultarMissoes.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.setUserData(conexao);
            stage.show();
        }catch(Exception e){ System.out.println(e);} 
    }
    
    @FXML
    private void cadastrarPlanetas(ActionEvent event) {
        System.out.println("Cadastrar planetas");
        try{
            Stage stage = (Stage) bMissoes.getScene().getWindow();
            stage.setTitle("Cadastrar Planetas");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastrarPlanetas.fxml"));
            stage.setUserData(conexao);
            stage.setScene(new Scene(loader.load()));
            stage.show();
            stopThreads();
        }catch(Exception e){ System.out.println(e+"oi");} 
    }
    
    @FXML
    private void cadastrarRotas(ActionEvent event) {
        System.out.println("Cadastrar rotas");
    }

    private void stopThreads(){
        conexaoThread.stop();
        verificaConexaoThread.stop();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("INICIO CONTROLLER!");
        conexao = null;
        conexaoThread.start();
        
    }    
    
}
