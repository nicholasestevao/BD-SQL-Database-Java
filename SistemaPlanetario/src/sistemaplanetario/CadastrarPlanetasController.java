
package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;


public class CadastrarPlanetasController implements Initializable {

    @FXML
    private Button bVoltar;
    
    @FXML
    private TextField tfPlaneta;
    
    @FXML
    private TextField tfClima;
    
    @FXML
    private TextField tfPressao;
    
     @FXML
    private TextField tfTemperatura;
    
    @FXML
    private Button bCadastrar;
    
    @FXML
    private ComboBox<SistemaPlanetario> cbSistema;
    
    private Conexao conexao;
    
    
    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                System.out.println("Obtendo conexão...");
                System.out.println(conexao);      

                if(conexao == null){
                    Stage stage = (Stage)bVoltar.getScene().getWindow();
                    conexao = (Conexao) stage.getUserData();
                    conexao.imprimeConexao();
                    
                    ResultSet resultSet = conexao.executaLinhaSQL("SELECT NOME, GALAXIA FROM SISTEMA_PLANETARIO");

                    cbSistema.setVisibleRowCount(5);

                    while(resultSet.next()){
                        SistemaPlanetario s = new SistemaPlanetario(resultSet.getString(1), resultSet.getString(2));
                        cbSistema.getItems().add(s);
                    }
                    
                    this.stop();
                    verificaConexaoThread.start();
                }   
            }
            catch(SQLException s){
                System.out.println("ERRO: a conexão SQL apresentou erro - " + s.getMessage());
                conexao = null;
            }
        }
    };

    private AnimationTimer verificaConexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                if(!conexao.estaConectado()){
                    Stage stage = (Stage)bVoltar.getScene().getWindow();
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
            
        }
    };

    @FXML
    private void cadastrar(ActionEvent event) {
        try{
            SistemaPlanetario sistemaPlanetario = cbSistema.getValue();
            String sistema = sistemaPlanetario.getNome();
            String galaxia = sistemaPlanetario.getGalaxia();
            String planeta = tfPlaneta.getText();
            int temperatura = Integer.parseInt(tfTemperatura.getText());
            int pressao = Integer.parseInt(tfPressao.getText());
            String clima = tfClima.getText();

            ResultSet resultSet = conexao.executaLinhaSQL("INSERT INTO PLANETA values ((SELECT max(id) + 1 FROM PLANETA), \'"+ sistema +"\', \'"+ galaxia +"\', \'"+ planeta +"\', "+ temperatura +", "+ pressao +", \'"+ clima +"\' )");
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));  
            }
        }
        catch(SQLException s){
            System.out.println("ERRO: Não foi possível cadastrar o planeta!");
        }
    }
    
    @FXML
    private void voltarInicio(ActionEvent event) {
        System.out.println("Voltar");
        try{
            //conexao.fechaConexao();
            Stage stage = (Stage)bVoltar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Início");
            stage.setUserData(conexao);
            stage.setScene(scene);
            stage.show();
            stopThreads();
        }
        catch(IOException e){
            System.out.println("Não foi possível abrir a tela de Inicio.");
        }
    }

    private void stopThreads(){
        conexaoThread.stop();
        verificaConexaoThread.stop();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("CADASTRAR PLANETAS CONTROLLER!");
        conexao = null;
        conexaoThread.start(); 
    }    
    
}
