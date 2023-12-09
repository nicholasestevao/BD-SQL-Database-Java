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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe LoginController que implementa a interface Initializable.
 * Esta classe é responsável por controlar as ações na tela de login.
 */
public class LoginController implements Initializable{
    @FXML
    private TextField tf_usuario; // Campo de texto para o usuário inserir o nome de usuário
    @FXML
    private TextField tf_host; // Campo de texto para o usuário inserir o host
    @FXML
    private TextField tf_porta; // Campo de texto para o usuário inserir a porta
    @FXML
    private TextField tf_servico; // Campo de texto para o usuário inserir o serviço
    @FXML
    private PasswordField pf_senha; // Campo de senha para o usuário inserir a senha
    @FXML
    private Button button_entrar; // Botão para iniciar a sessão

    /**
     * Método para realizar o login do usuário.
     * Este método é chamado quando o botão 'Entrar' é pressionado.
     * @param event O evento de ação que ocorreu.
     */
    @FXML
    private void login(ActionEvent event){
        // Pega o nome de usuário
        String usuario = tf_usuario.getText();
        if(usuario.isEmpty()){
            System.out.println("ERRO: Usuario vazio.");
            return;
        }

        // Pega a senha do usuário
        String senha = pf_senha.getText();
        if(senha.isEmpty()){
            System.out.println("ERRO: Senha vazia.");
            return;
        }
        
        // Pega o host para consexão com a Base de Dados
        String host = tf_host.getText();
        if(host.isEmpty()){
            System.out.println("ERRO: Host vazio.");
            return;
        }

        // Pega a porta para consexão com a Base de Dados
        String sPorta = tf_porta.getText();
        if(sPorta.isEmpty()){
            System.out.println("ERRO: Porta vazia.");
            return;
        }
        int porta = Integer.parseInt(sPorta);
        tf_porta.setText(sPorta);

        // Pega o serviço para consexão com a Base de Dados
        String servico = tf_servico.getText();
        if(servico.isEmpty()){
            System.out.println("ERRO: Serviço vazio.");
            return;
        }

        // Tenta realizar a conexão com o banco
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Conexão");
            alert.setHeaderText("ERRO: não foi possível conectar ao servidor ORACLE.");
            alert.setContentText(s.getLocalizedMessage());
            alert.showAndWait();
        }
        catch(IOException e){
            System.out.println("Não foi possível gerar a tela de Menu.");
            e.printStackTrace();
        }   
    }

    /**
     * Método para inicializar o controlador após a raiz do elemento ter sido completamente processada.
     * Este método é chamado para configurar a tela de login.
     * @param url A localização usada para resolver caminhos relativos para o objeto raiz, ou null se a localização não é conhecida.
     * @param rb O recurso usado para localizar o objeto raiz, ou null se o objeto raiz foi localizado.
     */
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

        // Define dados do usuário como fixo para entrar em nossa base de dados
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