
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

/**
 * Classe InicioController que implementa a interface Initializable.
 * Esta classe é responsável por controlar as ações na tela inicial.
 */
public class InicioController implements Initializable {

    @FXML
    private Button bMissoes; // Botão para consultar missões
    
    @FXML
    private Button bPlanetas; // Botão para cadastrar planetas
    
    @FXML
    private Button bRotas; // Botão para consultar rotas

    private Connection conexao; // Conexão com o banco de dados

    /**
     * Thread para obter a conexão com o banco de dados.
     */
    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            System.out.println("Obtendo conexão...");
            if(conexao == null){
                Stage stage = (Stage) bMissoes.getScene().getWindow();
                conexao = (Connection) stage.getUserData();

                if(conexao == null)
                    return;

                try{
                    System.out.println(conexao.getClientInfo().toString());
                }
                catch(SQLException s){
                    System.out.println(s.getMessage());
                }
                
                verificaConexaoThread.start();
                this.stop();
            }
            else
                conexao = null;
        }
    };

    /**
     * Thread para verificar a conexão com o banco de dados.
     */
    private AnimationTimer verificaConexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                if(!conexao.isValid(5000)){
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
    
    /**
     * Método para consultar missões.
     * Este método é chamado quando o botão 'Consultar Missões' é pressionado.
     * @param event O evento de ação que ocorreu.
     */
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
            stopThreads();
        }catch(Exception e){ System.out.println(e);} 
    }
    
    /**
     * Método para cadastrar planetas.
     * Este método é chamado quando o botão 'Cadastrar Planetas' é pressionado.
     * @param event O evento de ação que ocorreu.
     */
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
    
    /**
     * Método para consultar planetas.
     * Este método é chamado quando o botão 'Consultar Planetas' é pressionado.
     * @param event O evento de ação que ocorreu.
     */
    @FXML
    private void consultarPlanetas(ActionEvent event) {
        System.out.println("Consultar planetas");
        try{
            Stage stage = (Stage) bMissoes.getScene().getWindow();
            stage.setTitle("Consultar planetas");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultarPlanetas.fxml"));
            stage.setUserData(conexao);
            stage.setScene(new Scene(loader.load()));
            stage.show();
            stopThreads();
        }catch(Exception e){ System.out.println(e+"oi");} 
    }

    /**
     * Método para parar as threads.
     */
    private void stopThreads(){
        conexaoThread.stop();
        verificaConexaoThread.stop();
    }

    /**
     * Método para inicializar o controlador após a raiz do elemento ter sido completamente processada.
     * Este método é chamado para configurar a tela inicial.
     * @param url A localização usada para resolver caminhos relativos para o objeto raiz, ou null se a localização não é conhecida.
     * @param rb O recurso usado para localizar o objeto raiz, ou null se o objeto raiz foi localizado.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("INICIO CONTROLLER!");
        conexao = null;
        conexaoThread.start();
    }    
}