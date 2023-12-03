
package sistemaplanetario;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    
    private Connection con;
    
    @FXML
    private void cadastrar(ActionEvent event) {
        System.out.println("Cadastrar");
        try{
            Statement stmt=con.createStatement();  
            
            ResultSet rs=stmt.executeQuery("insert into Planeta values ((select max(id) + 1 from Planeta), '"+cbSistema.getValue().getNome()+"', '"+cbSistema.getValue().getGalaxia()+"', '"+tfPlaneta.getText()+"', "+Integer.parseInt(tfTemperatura.getText())+", "+Integer.parseInt(tfPressao.getText())+", '"+tfClima.getText()+"' )");
            while(rs.next()){
                System.out.println(rs.getString(1));  
            }
        }catch(Exception e){ System.out.println(e);} 
    }
    
    @FXML
    private void voltarInicio(ActionEvent event) {
        System.out.println("Voltar");
        try{
            Stage stage = (Stage) bVoltar.getScene().getWindow();
            stage.setTitle("Início");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.show();
            con.close(); 
        }catch(Exception e){ System.out.println(e);} 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*tfPlaneta.textProperty().addListener((observable, oldValue, newValue) -> {
		if (newValue.length() > 50) {
			tfPlaneta.setText(oldValue.substring(0, 50));
		}
	});*/
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection(  
            "jdbc:oracle:thin:@orclgrad1.icmc.usp.br:1521/pdb_elaine.icmc.usp.br","a12732037","li30dukp");  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("SELECT nome, galaxia FROM sistema_planetario");
            cbSistema.setVisibleRowCount(5);
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2));  
                SistemaPlanetario s = new SistemaPlanetario(rs.getString(1), rs.getString(2));
                cbSistema.getItems().add(s);
            }
        }
        catch(Exception e){
            System.out.println("Não foi possível conectar ao servidor da ORACLE: ");
            System.out.println(e.getMessage());
        }  
    }    
    
}
