package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable{
    @FXML
    private TextField tf_usuario;
    @FXML
    private TextField tf_host;
    @FXML
    private TextField tf_porta;
    @FXML
    private TextField tf_servico;
    @FXML
    private PasswordField pf_senha;
    @FXML
    private Button button_entrar;

    @FXML
    private void login(ActionEvent event){
        //String usuario = tf_usuario.getText();
        String usuario = "a12732037";
        if(usuario.isEmpty()){
            System.out.println("ERRO: Usuario vazio.");
            return;
        }

        //String senha = pf_senha.getText();
        String senha = "li30dukp";
        if(senha.isEmpty()){
            System.out.println("ERRO: Senha vazia.");
            return;
        }
        
        //String host = tf_host.getText();
        String host = "orclgrad1.icmc.usp.br";
        if(host.isEmpty()){
            System.out.println("ERRO: Host vazio.");
            return;
        }

        //String sPorta = tf_porta.getText();
        String sPorta = "1521";
        if(sPorta.isEmpty()){
            System.out.println("ERRO: Porta vazia.");
            return;
        }
        int porta = Integer.parseInt(sPorta);
        tf_porta.setText(sPorta);

        //String servico = tf_servico.getText();
        String servico = "pdb_elaine.icmc.usp.br";
        if(servico.isEmpty()){
            System.out.println("ERRO: Serviço vazio.");
            return;
        }

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            
            String url = "jdbc:oracle:thin:@"+ host + ":" + porta + "/" + servico;
            DriverManager.setLoginTimeout(5);
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            conexao.setAutoCommit(false);

            Stage stage = (Stage) button_entrar.getScene().getWindow();
            
            Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
            Scene scene = new Scene(root);
            
            stage.setUserData(conexao);
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();

        }
        catch(ClassNotFoundException e){
            System.out.println("ERRO: não foi possível abrir a biblioteca JDBC. Verifique o arquivo ojdbc11.jar.");
        }
        catch(SQLException s){
            System.out.println("ERRO: não foi possível conectar ao servidor ORACLE.");
        }
        catch(IOException e){
            System.out.println("Não foi possível gerar a tela de Menu.");
            e.printStackTrace();
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tf_porta.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    tf_porta.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        String usuario = "a12732037";
        tf_usuario.setText(usuario);
        String senha = "li30dukp";
        pf_senha.setText(senha);
        String host = "orclgrad1.icmc.usp.br";
        tf_host.setText(host);
        String sPorta = "1521";
        tf_porta.setText(sPorta);
        String servico = "pdb_elaine.icmc.usp.br";
        tf_servico.setText(servico);
    }
}
