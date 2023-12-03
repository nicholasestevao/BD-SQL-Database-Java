/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobd;

import java.net.URL;
import java.sql.*; 
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Nicho
 */
public class InterfaceController implements Initializable {
    
    
    @FXML
    private ComboBox cbPlaneta;
    
    @FXML
    private ComboBox cbRotas;
    
    private Connection con;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        try{
            //step3 create the statement object  
            Statement stmt=con.createStatement();  

            //step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from time");
            cbPlaneta.setVisibleRowCount(5);
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
                cbPlaneta.getItems().add(rs.getString(1));
            }
        }catch(Exception e){ System.out.println(e);}  
    }
    
    @FXML
    private void planetaSelecionado(ActionEvent event) {
        System.out.println("You clickasdasdased me!");
        
        try{
            //step3 create the statement object  
            Statement stmt=con.createStatement();  

            //step4 execute query  
            ResultSet rs=stmt.executeQuery("select * from jogador where time='"+cbPlaneta.getValue()+"'");
            cbRotas.setVisibleRowCount(5);
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getDate(4)+"  "+rs.getString(5)+"  "+rs.getString(6));  
                cbRotas.getItems().add(rs.getString(1));
            }
            System.out.println("teste");
        }catch(Exception e){ System.out.println(e);}  
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{  
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  

            //step2 create  the connection object  
            con=DriverManager.getConnection(  
            "jdbc:oracle:thin:@orclgrad1.icmc.usp.br:1521/pdb_elaine.icmc.usp.br","a12689616","feqziq153");  

            //...
            //step5 close the connection object  
            //con.close();  
            

        }catch(Exception e){ System.out.println(e);} 
    }    
    
}
