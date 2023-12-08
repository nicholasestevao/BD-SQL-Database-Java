package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.animation.AnimationTimer;
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
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ConsultarPlanetasController implements Initializable {
    
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
    
    private Conexao conexao;
    
    private ObservableList<MissaoEspacial> listaMissoes;
    
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

    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                System.out.println("Obtendo conexão...");
                System.out.println("Conexao atual: " + conexao);      

                if(conexao == null){
                    Stage stage = (Stage)bVoltar.getScene().getWindow();
                    conexao = (Conexao) stage.getUserData();
                    conexao.imprimeConexao();
                    
                    ResultSet resultSet = conexao.executaLinhaSQL("SELECT PLANETA, NOME FROM BASE_ESPACIAL");
                    cbBase.setVisibleRowCount(5);

                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        String nome = resultSet.getString(2);

                        System.out.println(id + " " + nome);

                        String comando = "SELECT NOME FROM PLANETA WHERE ID = " + id;
                        ResultSet resultSet2 = conexao.executaLinhaSQL(comando);
                        resultSet2.next();
                        BaseEspacial s = new BaseEspacial(resultSet.getInt(1), resultSet2.getString(1), resultSet.getString(2));
                        cbBase.getItems().add(s);
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
    private void buscar(ActionEvent event) {
        BaseEspacial baseOrigem = cbBase.getValue();
        String nomeMissao = tfNome.getText();
        LocalDate dataMissao = dpData.getValue();

        String select = "SELECT * ";
        String from = "FROM MISSAO_ESPACIAL "; 
        String where = "";

        if(baseOrigem != null){
            if(where.isEmpty())
                where += "WHERE ";
            else
                where += "AND ";
            where += "PLANETA_BASE = " + baseOrigem.getPlaneta() + " AND NOME_BASE LIKE \'%" + baseOrigem.getNome() + "%\' ";
        }

        if(!nomeMissao.isEmpty()){
            if(where.isEmpty())
                where += "WHERE ";
            else
                where += "AND ";
            where += "NOME LIKE \'%" + nomeMissao + "%\' ";
        }

        if(dataMissao != null){
            if(where.isEmpty())
                where += "WHERE ";
            else
                where += "AND ";
            where += "DATA_INICIO LIKE TO_DATE(\'" + dataMissao.getDayOfMonth() + "-"  + dataMissao.getMonthValue() + "-" + dataMissao.getYear() + "\',\'dd-mm-yyyy\')";
        }

        try{
            System.out.println(select + from + where);
            ResultSet resultSet = conexao.executaLinhaSQL(select + from + where);

            listaMissoes.clear();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                int idPlanetaBase = resultSet.getInt(2);
                String nomeBase = resultSet.getString(3);
                String nome = resultSet.getString(4);
                String dataInicio =resultSet.getString(5);
                String dataFim = resultSet.getString(6);
                String descricao = resultSet.getString(7);
                int tamTripulacao = resultSet.getInt(8);
                String objetivo = resultSet.getString(9);
                int duracao = resultSet.getInt(10);
                int nivelPerigo = resultSet.getInt(11);

                MissaoEspacial missaoEspacial = new MissaoEspacial(id, idPlanetaBase, nomeBase, nome, dataInicio, dataFim, descricao, tamTripulacao, objetivo, duracao, nivelPerigo);
                listaMissoes.add(missaoEspacial);
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
        System.out.println("CADASTRAR PLANETAS CONTROLLER!");
        conexao = null;
        conexaoThread.start(); 
        
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
