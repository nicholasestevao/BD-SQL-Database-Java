package sistemaplanetario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Controlador para a tela de consulta de missões espaciais.
 * Implementa a interface Initializable para inicialização do controlador.
 */
public class ConsultarMissoesController implements Initializable {
    private Connection conexao; // Conexão com o banco de dados
    
    private ObservableList<MissaoEspacial> listaMissoes; // Lista observável para armazenar missões espaciais

    @FXML
    private Button bVoltar; // Botão para voltar à tela inicial
    
    @FXML
    private ComboBox<BaseEspacial> cbBase; // ComboBox para selecionar bases espaciais
    
    @FXML
    private TextField tfNome; // Campo de texto para inserir o nome da missão
    
    @FXML
    private DatePicker dpData; // Seletor de data para a data da missão
    
    @FXML
    private Button bBuscar; // Botão para realizar a busca de missões
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcIdPlaneta; // Coluna ID da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcBase; // Coluna Base Espacial da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcNomeMissao; // Coluna Nome da Missão da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDataInicio; // Coluna Data de Início da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDataFim; // Coluna Data de Fim da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcDescricao; // Coluna Descrição da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcTripulacao; // Coluna Tripulação da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, String> tcObjetivo; // Coluna Objetivo da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcDuracao; // Coluna Duração da tabela
    
    @FXML
    private TableColumn<MissaoEspacial, Integer> tcPericulosidade; // Coluna Periculosidade da tabela
    
    @FXML
    private TableView<MissaoEspacial> tbMissoes; // Tabela para exibição dos resultados da busca

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

                    cbBase.getItems().add(null);
                    
                    ResultSet resultSet = conexao.prepareStatement("SELECT PLANETA, NOME FROM BASE_ESPACIAL").executeQuery();
                    cbBase.setVisibleRowCount(5);

                    while(resultSet.next()){
                        int id = resultSet.getInt(1);
                        PreparedStatement linha = conexao.prepareStatement("SELECT NOME FROM PLANETA WHERE ID = ?");
                        linha.setInt(1, id);

                        ResultSet resultSet2 = linha.executeQuery();
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
            catch(Exception e){
                System.out.println(e.getLocalizedMessage());
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
     * Método para realizar a busca de missões espaciais com base nos critérios especificados.
     *
     * @param event O evento de clique no botão de busca.
     */
    @FXML
    private void buscar(ActionEvent event) {
        try{
            dpData.commitValue();
            BaseEspacial baseOrigem = cbBase.getValue();
            String nomeMissao = tfNome.getText();
            LocalDate dataMissao = null;

            if(dpData.getValue() != null)
                dataMissao = dpData.getValue();
            else
                dpData.setValue(null);    

            String linhaSQL = "SELECT * FROM MISSAO_ESPACIAL ";

            ArrayList atributosLinha = new ArrayList();
        
            if(baseOrigem != null){
                if(!linhaSQL.contains("WHERE"))
                    linhaSQL += "WHERE ";
                else
                    linhaSQL += "AND ";
                linhaSQL += "PLANETA_BASE = ? AND NOME_BASE LIKE ? ";
                atributosLinha.add(baseOrigem.getPlaneta());
                atributosLinha.add(baseOrigem.getNome());
            }

            if(!nomeMissao.isEmpty()){
                if(!linhaSQL.contains("WHERE"))
                    linhaSQL += "WHERE ";
                else
                    linhaSQL += "AND ";
                linhaSQL += "NOME LIKE ? ";
                atributosLinha.add(nomeMissao);
            }

            if(dataMissao != null){
                if(!linhaSQL.contains("WHERE"))
                    linhaSQL += "WHERE ";
                else
                    linhaSQL += "AND ";
                linhaSQL += "DATA_INICIO LIKE TO_DATE(?,\'dd-mm-yyyy\')";
                String data = dataMissao.getDayOfMonth() + "-" + dataMissao.getMonthValue() + "-" + dataMissao.getYear();
                System.out.println(data);
                atributosLinha.add(data);
            }
            
            System.out.println(linhaSQL);

            PreparedStatement linha = conexao.prepareStatement(linhaSQL);
            for(int i = 0; i < atributosLinha.size(); i++){
                if (atributosLinha.get(i) instanceof String)
                    linha.setString(i+1, (String) atributosLinha.get(i));
                else
                    linha.setInt(i+1, (int) atributosLinha.get(i));
            }

            ResultSet resultSet = linha.executeQuery();

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
        }
        catch(SQLException s){

        } 
        catch(DateTimeParseException d){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na data.");
            alert.setHeaderText("Você inseriu um valor inválido na data.");
            alert.setContentText(d.getLocalizedMessage());
            alert.showAndWait();
            return;
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
     * Método para mostrar a data selecionada no console.
     *
     * @param event O evento de seleção de data.
     */
    @FXML
    private void mostrardata(ActionEvent event) {
        System.out.println(dpData.getValue().getDayOfMonth() + " " + dpData.getValue().getMonthValue() + " " + dpData.getValue().getYear());
        
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
        System.out.println("CADASTRAR PLANETAS CONTROLLER!");
        conexao = null;
        conexaoThread.start(); 
        
        tcIdPlaneta.setCellValueFactory(new PropertyValueFactory<MissaoEspacial, Integer>("id"));
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
