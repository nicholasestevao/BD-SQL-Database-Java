
package trabalhobd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class InicioController implements Initializable {

    
    @FXML
    private Button bMissoes;
    
    @FXML
    private Button bPlanetas;
    
    @FXML
    private Button bRotas;
    
    @FXML
    private void consultarMissoes(ActionEvent event) {
        System.out.println("Consultar missoes");
        try{
            Stage stage = (Stage) bMissoes.getScene().getWindow();
            stage.setTitle("Consultar missões");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ConsultarMissoes.fxml"));
            stage.setScene(new Scene(loader.load()));
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
            stage.setScene(new Scene(loader.load()));
            stage.show();
        }catch(Exception e){ System.out.println(e+"oi");} 
    }
    
    @FXML
    private void cadastrarRotas(ActionEvent event) {
        System.out.println("Cadastrar rotas");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
