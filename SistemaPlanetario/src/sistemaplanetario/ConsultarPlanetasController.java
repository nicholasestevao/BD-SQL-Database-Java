package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Controlador para a tela de consulta de planetas.
 * Implementa a interface Initializable para inicialização do controlador.
 */
public class ConsultarPlanetasController implements Initializable {
    
    private Connection conexao; // Conexão com o banco de dados

    private ObservableList<Planeta> listaPlanetas; // Lista observável para armazenar planetas

    @FXML
    private Button bVoltar; // Botão para voltar à tela inicial

    @FXML
    private Button bBuscar; // Botão para realizar a busca de planetas

    @FXML
    private ComboBox<SistemaPlanetario> cbSistemasPlanetarios; // ComboBox para selecionar sistemas planetários

    @FXML
    private TextField tfNomePlaneta; // Campo de texto para inserir o nome do planeta a ser buscado

    @FXML
    private TableView<Planeta> tbPlanetas; // Tabelas para exibição dos resultados da busca

    @FXML
    private TableColumn<Planeta, Integer> tcIDPlaneta; // Coluna ID da tabela
    
    @FXML
    private TableColumn<Planeta, String> tcSistemaPlanetario; // Coluna Sistema Planetário da tabela
    
    @FXML
    private TableColumn<Planeta, String> tcGalaxia; // Coluna Galáxia da tabela
    
    @FXML
    private TableColumn<Planeta, String> tcNomePlaneta; // Coluna Nome da tabela
    
    @FXML
    private TableColumn<Planeta, Float> tcTemperatura; // Coluna Temperatura da tabela
    
    @FXML
    private TableColumn<Planeta, Float> tcPressao; // Coluna Pressao da tabela
    
    @FXML
    private TableColumn<Planeta, String> tcClima; // Coluna Clima da tabela

    // Thread para obter a conexão com o banco de dados
    private AnimationTimer conexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                System.out.println("Obtendo conexão...");
                System.out.println("Conexao atual: " + conexao);      

                if(conexao == null){
                    Stage stage = (Stage)bVoltar.getScene().getWindow();
                    conexao = (Connection) stage.getUserData();
                    cbSistemasPlanetarios.getItems().add(null);
                    ResultSet resultSet = conexao.prepareStatement("SELECT NOME, GALAXIA FROM SISTEMA_PLANETARIO").executeQuery();
                    cbSistemasPlanetarios.setVisibleRowCount(5);
                    while(resultSet.next()){
                        String nomeSistema = resultSet.getString(1);
                        String galaxiaSistema = resultSet.getString(2);

                        String sistema = nomeSistema + " - " + galaxiaSistema;
                        cbSistemasPlanetarios.getItems().add(new SistemaPlanetario(nomeSistema, galaxiaSistema));
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

    // Thread para verificar a validade da conexão
    private AnimationTimer verificaConexaoThread = new AnimationTimer(){
        @Override
        public void handle(long now){
            try{
                if(!conexao.isValid(5000)){
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

    /**
     * Método para buscar planetas com base nos critérios especificados.
     *
     * @param event O evento de clique no botão de busca.
     */
    @FXML
    private void buscar(ActionEvent event) {
        String linhaSQL = "SELECT * FROM PLANETA ";
        SistemaPlanetario sistemaPlanetario = cbSistemasPlanetarios.getValue();
        ArrayList atributosLinha = new ArrayList<>();
        if(sistemaPlanetario != null){
            if(!linhaSQL.contains("WHERE"))
                linhaSQL += "WHERE ";
            else
                linhaSQL += "AND ";
            linhaSQL += "SISTEMA_PLANETARIO = ? AND GALAXIA = ? ";
            atributosLinha.add(sistemaPlanetario.getNome());
            atributosLinha.add(sistemaPlanetario.getGalaxia());
        }

        String nomePlaneta = tfNomePlaneta.getText();
        if(!nomePlaneta.isEmpty()){
            if(!linhaSQL.contains("WHERE"))
                linhaSQL += "WHERE ";
            else
                linhaSQL += "AND ";
            linhaSQL += "NOME = ?";
            atributosLinha.add(nomePlaneta);
        }

        System.out.println(linhaSQL);

        try{
            PreparedStatement linha = conexao.prepareStatement(linhaSQL);
            for(int i = 0; i < atributosLinha.size(); i++){
                if (atributosLinha.get(i) instanceof String)
                    linha.setString(i+1, (String) atributosLinha.get(i));
                else
                    linha.setInt(i+1, (int) atributosLinha.get(i));
            }

            ResultSet resultado = linha.executeQuery();

            listaPlanetas.clear();

            while(resultado.next()){
                int id = resultado.getInt(1);
                String nomeSistema = resultado.getString(2);
                String galaxia = resultado.getString(3);
                String nome = resultado.getString(4);
                float temperatura = resultado.getFloat(5);
                float pressao = resultado.getFloat(6);
                String clima = resultado.getString(7);

                System.out.println(galaxia);
                Planeta planeta = new Planeta(id, nomeSistema, galaxia, nome, temperatura, pressao, clima);
                listaPlanetas.add(planeta);
            }
            tbPlanetas.setItems(listaPlanetas);
        }
        catch(SQLException s){

        }
    }
    
    /**
     * Método para voltar à tela inicial.
     *
     * @param event O evento de clique no botão de voltar.
     */
    @FXML
    private void voltarInicio(ActionEvent event) {
        System.out.println("Voltar");
        try{
            Stage stage = (Stage) bVoltar.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Início");
            stage.setScene(scene);
            stage.setUserData((Connection) conexao);
            stage.show();
            stopThreads();
        }catch(Exception e){ System.out.println(e);} 
    }

    /**
     * Método para parar as threads.
     */
    private void stopThreads(){
        conexaoThread.stop();
        verificaConexaoThread.stop();
    }
    
    /**
     * Método para inicializar o controlador após a raiz do elemento ter sido completamente processada.
     * Configura as colunas da tabela e inicia a thread de obtenção de conexão.
     *
     * @param url A localização usada para resolver caminhos relativos para o objeto raiz, ou null se a localização não é conhecida.
     * @param rb  O recurso usado para localizar o objeto raiz, ou null se o objeto raiz foi localizado.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("CONSULTAR PLANETAS CONTROLLER!");
        conexao = null;
        conexaoThread.start(); 
        
        tcIDPlaneta.setCellValueFactory(new PropertyValueFactory<Planeta, Integer>("id"));
        tcSistemaPlanetario.setCellValueFactory(new PropertyValueFactory<Planeta, String>("sistemaPlanetario"));
        tcGalaxia.setCellValueFactory(new PropertyValueFactory<Planeta, String>("galaxia"));
        tcNomePlaneta.setCellValueFactory(new PropertyValueFactory<Planeta, String>("nome"));
        tcTemperatura.setCellValueFactory(new PropertyValueFactory<Planeta,Float>("temperatura"));
        tcPressao.setCellValueFactory(new PropertyValueFactory<Planeta,Float>("pressao"));
        tcClima.setCellValueFactory(new PropertyValueFactory<Planeta,String>("clima"));

        listaPlanetas = FXCollections.observableArrayList();
        
        tbPlanetas.setItems(listaPlanetas);
    }      
}