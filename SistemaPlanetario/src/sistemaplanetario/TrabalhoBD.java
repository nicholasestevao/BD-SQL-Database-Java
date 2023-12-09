package sistemaplanetario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage; 

/**
 * Classe principal que inicia o programa.
 */
public class TrabalhoBD extends Application {
    
    /**
     * Método principal que inicia o programa.
     *
     * @param args os argumentos da linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
        
    }

    /**
     * Inicia o programa carregando a interface do usuário e exibindo-a na tela.
     *
     * @param stage o palco principal da interface do usuário.
     * @throws Exception se ocorrer um erro ao carregar a interface do usuário.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);

        stage.setTitle("Login");
        stage.getIcons().add(new Image("icone.png"));

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}