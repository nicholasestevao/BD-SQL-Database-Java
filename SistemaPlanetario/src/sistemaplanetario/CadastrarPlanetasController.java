
package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Alert;


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
    
    private Connection conexao;
    
    
    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                System.out.println("Obtendo conexão...");
                System.out.println(conexao);      

                if(conexao == null){
                    Stage stage = (Stage) bVoltar.getScene().getWindow();
                    conexao = (Connection) stage.getUserData();
                    
                    ResultSet resultSet = conexao.prepareStatement("SELECT NOME, GALAXIA FROM SISTEMA_PLANETARIO").executeQuery();

                    cbSistema.setVisibleRowCount(5);

                    while(resultSet.next()){
                        SistemaPlanetario s = new SistemaPlanetario(resultSet.getString(1), resultSet.getString(2));
                        cbSistema.getItems().add(s);
                    }
                    resultSet.close();
                    this.stop();
                    verificaConexaoThread.start();
                }   
            }
            catch(SQLException s){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Falha na conexão");
                alert.setContentText("Ocorreu uma falha na conexão");
                alert.showAndWait();

                System.out.println("ERRO: a conexão SQL apresentou erro - " + s.getMessage());
                conexao = null;
            }
        }
    };

    private AnimationTimer verificaConexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                if(!conexao.isValid(5000)){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Desconectado");
                    alert.setContentText("Você foi desconectado!");
                    alert.showAndWait();

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
            String nome = tfPlaneta.getText();
            float temperatura = Float.parseFloat(tfTemperatura.getText());
            System.out.println(temperatura + " " + tfTemperatura.getText());
            float pressao = Float.parseFloat(tfPressao.getText());
            String clima = tfClima.getText();

            PreparedStatement obtemID = conexao.prepareStatement("SELECT MAX (ID) + 1 FROM PLANETA");
            ResultSet r = obtemID.executeQuery();
            int id = 1;
            while(r.next())
                id = r.getInt(1);
            r.close();

            PreparedStatement linha = conexao.prepareStatement("INSERT INTO PLANETA values (?,?,?,?,?,?,?)");
            linha.setInt(1, id);
            linha.setString(2, sistema);
            linha.setString(3, galaxia);
            linha.setString(4, nome);
            linha.setFloat(5, temperatura);
            linha.setFloat(6, pressao);
            linha.setString(7, clima);
            linha.executeUpdate();

            conexao.commit();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Planeta cadastrado");
            alert.setHeaderText("Planeta cadastrado.");
            alert.setContentText("O planeta " + nome + " foi cadastrado!");
            alert.showAndWait();

            tfPlaneta.setText("");
            tfClima.setText("");
            tfPressao.setText("");
            tfTemperatura.setText("");
        }
        catch(SQLException s){
            Alert alert = new Alert(Alert.AlertType.ERROR);
        
            System.out.println(s.getSQLState());
            System.out.println(s.getErrorCode());
            System.out.println(s.getMessage());

            String mensagem = "";
            String titulo = "";
            if(s.getErrorCode() == 1){
                mensagem = "Esse planeta já está cadastrado no sistema.";
                titulo = "Planeta já cadastrado";
            }
            else if(s.getErrorCode() == 1400){
                mensagem = "Não é possível inserir NULL no atributo.";
                titulo = "Atributo NULL";
            }
            else{
                mensagem = s.getMessage();
                titulo = "Erro ao cadastrar";
            }
            alert.setTitle(titulo);
            alert.setContentText(mensagem);
            alert.showAndWait();

            try{
                conexao.rollback();
            }
            catch(SQLException sq){
                System.out.println("Rollback não executado!");
            }
        }

    }
    
    @FXML
    private void voltarInicio(ActionEvent event) {
        System.out.println("Voltar");
        try{
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

        tfTemperatura.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfTemperatura.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            }
        });

        tfPressao.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfPressao.setText(newValue.replaceAll("[^\\d.]", ""));
                }
            }
        });
    }    
    
}
