
package sistemaplanetario;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ConsultarMissoesController implements Initializable {
    
    @FXML
    private Button bVoltar;
    
    @FXML
    private ComboBox<BaseEspacial> cbBase;
    
    @FXML
    private TextField tfNome;
    
    @FXML
    private DatePicker dpData;
    
    @FXML
    private Button bBuscar;
    
    private Connection con;
    
    private ObservableList<MissaoEspacial> listaMissoes;
    
    //@FXML
    //private TableColumn<MissaoEspacial, String> tcNomePlaneta;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcBase;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcNomeMissao;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDataInicio;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDataFim;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDescricao;
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcTripulacao;
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcObjetivo;
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcDuracao;
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcPericulosidade;
    
    @FXML
    private TableView<MissaoEspacial> tbMissoes;
    
    
    
    
     @FXML
    private void buscar(ActionEvent event) {
        System.out.println("Buscar");
        try{
            Statement stmt=con.createStatement();  
            //ResultSet rs=stmt.executeQuery("select * from missao_espacial");
            String filtroBase = (cbBase.getValue() != null)?"planeta_base="+cbBase.getValue().getPlaneta()+" and nome_base LIKE '"+cbBase.getValue().getNome()+"' ":"";
            String filtroNome = (tfNome.getText().length() > 0)?"(nome LIKE '"+tfNome.getText()+"%') ":"";
            String filtroData = (dpData.getValue()  != null)?"data_inicio LIKE TO_DATE('"+dpData.getValue().getDayOfMonth()+"-"+ dpData.getValue().getMonthValue()+"-"+dpData.getValue().getYear()+"','dd-mm-yyyy')":"";
            System.out.println("select * from missao_espacial ".concat((cbBase.getValue() != null || tfNome.getText().length() > 0 || dpData.getValue()  != null)?"where ":"").concat(filtroBase).concat((tfNome.getText().length() > 0 && cbBase.getValue() != null)?" and ":"").concat(filtroNome).concat((dpData.getValue()  != null && (cbBase.getValue() != null || tfNome.getText().length() > 0 ))?" and ":"").concat(filtroData));
            ResultSet rs=stmt.executeQuery("select * from missao_espacial ".concat((cbBase.getValue() != null || tfNome.getText().length() > 0 || dpData.getValue()  != null)?"where ":"").concat(filtroBase).concat((tfNome.getText().length() > 0 && cbBase.getValue() != null)?" and ":"").concat(filtroNome).concat((dpData.getValue()  != null && (cbBase.getValue() != null || tfNome.getText().length() > 0 ))?" and ":"").concat(filtroData));
            listaMissoes.clear();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+ rs.getInt(2)+" "+ rs.getString(3)+" "+ rs.getString(4)+" "+ rs.getDate(5)+" "+ rs.getDate(6)+" "+ rs.getString(7)+" "+ rs.getInt(8)+" "+ rs.getString(9)+" "+ rs.getInt(10)+" "+ rs.getInt(11));  
                MissaoEspacial m = new MissaoEspacial(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDate(5).toString(), rs.getDate(6).toString(), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getInt(11));  
                listaMissoes.add(m);
            }
            tbMissoes.setItems(listaMissoes);
        }catch(Exception e){ System.out.println(e+"oi");} 
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
        }catch(Exception e){ System.out.println(e);} 
    }

    @FXML
    private void mostrardata(ActionEvent event) {
        System.out.println(dpData.getValue().getDayOfMonth() + " " + dpData.getValue().getMonthValue() + " " + dpData.getValue().getYear());
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection(  
            "jdbc:oracle:thin:@orclgrad1.icmc.usp.br:1521/pdb_elaine.icmc.usp.br","a12689616","feqziq153");  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select planeta, nome from base_espacial");
            cbBase.setVisibleRowCount(5);
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
                Statement stmt2=con.createStatement(); 
                ResultSet rs2 = stmt2.executeQuery("select nome from planeta where id="+rs.getInt(1));
                rs2.next();
                BaseEspacial s = new BaseEspacial(rs.getInt(1), rs2.getString(1), rs.getString(2));
                cbBase.getItems().add(s);
            }
        }catch(Exception e){ System.out.println(e);}  
        
        tcBase.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("nomeBase"));
        tcNomeMissao.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("nome"));
        tcDataInicio.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("dataInicio"));
        tcDataFim.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("dataFim"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("descricao"));
        tcTripulacao.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, Integer>("tamTripulacao"));
        tcObjetivo.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, String>("objetivo"));
        tcDuracao.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, Integer>("duracao"));
        tcPericulosidade.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, Integer>("nivelPerigo"));
        
        listaMissoes = FXCollections.observableArrayList();
        
        tbMissoes.setItems(listaMissoes);
    }    
    
}
