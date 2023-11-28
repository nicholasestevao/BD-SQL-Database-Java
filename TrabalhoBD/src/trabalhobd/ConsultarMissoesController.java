
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


public class ConsultarMissoesController implements Initializable {
    
    @FXML
    private Button bVoltar;
    
    @FXML
    private void voltarInicio(ActionEvent event) {
        System.out.println("Voltar");
        try{
            Stage stage = (Stage) bVoltar.getScene().getWindow();
            stage.setTitle("Início");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.show();
        }catch(Exception e){ System.out.println(e);} 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
