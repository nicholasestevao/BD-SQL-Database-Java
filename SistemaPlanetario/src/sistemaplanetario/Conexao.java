package sistemaplanetario;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.lang.ClassNotFoundException;

/**
 * Classe para gerenciar a conexão com o banco de dados Oracle.
 */
public class Conexao {
    private Connection con; // Objeto de conexão com o banco de dados

    private String host; // Endereço do servidor de banco de dados
    private int porta; // Número da porta do servidor de banco de dados
    private String servico; // Nome do serviço do banco de dados
    private String usuario; // Nome de usuário para autenticação no banco de dados
    private String senha; // Senha de usuário para autenticação no banco de dados

    /**
     * Construtor da classe.
     *
     * @param host    Endereço do servidor de banco de dados.
     * @param porta   Número da porta do servidor de banco de dados.
     * @param servico Nome do serviço do banco de dados.
     * @param usuario Nome de usuário para autenticação no banco de dados.
     * @param senha   Senha de usuário para autenticação no banco de dados.
     */
    public Conexao(String host, int porta, String servico, String usuario, String senha) {
        this.host = host;
        this.porta = porta;
        this.servico = servico;
        this.usuario = usuario;
        this.senha = senha;

        con = null;
    }

    /**
     * Verifica se a conexão está ativa.
     *
     * @return true se a conexão estiver ativa, false caso contrário.
     * @throws SQLException se ocorrer um erro ao verificar a conexão.
     */
    public boolean estaConectado() throws SQLException {
        if (con == null)
            return false;

        return con.isValid(10);
    }

    /**
     * Inicia a conexão com o banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao iniciar a conexão.
     */
    public void iniciaConexao() throws SQLException {
        if (estaConectado()) {
            System.out.println("Usuário " + usuario + " já está conectado!");
            return;
        }

        System.out.println("Iniciando conexão...");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@" + host + ":" + porta + "/" + servico;
            System.out.println("URL: " + url);
            DriverManager.setLoginTimeout(5);
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(false);
            System.out.println("Você foi conectado!");
        } catch (ClassNotFoundException e) {
            System.out.println("ERRO: não foi possível abrir a biblioteca JDBC. Verifique o arquivo ojdbc11.jar.");
            System.out.println(e.getMessage());
        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     *
     * @throws SQLException se ocorrer um erro ao fechar a conexão.
     */
    public void fechaConexao() throws SQLException {
        if (!estaConectado()) {
            System.out.println("Usuário " + usuario + " não está conectado!");
            return;
        }
        con.close();
    }

    /**
     * Executa uma consulta SQL no banco de dados.
     *
     * @param linha A instrução SQL a ser executada.
     * @return Um ResultSet contendo os resultados da consulta.
     * @throws SQLException se ocorrer um erro durante a execução da consulta.
     */
    public ResultSet executaLinhaSQL(String linha) throws SQLException {
        if (con == null)
            return null;
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(linha);
        return resultSet;
    }

    /**
     * Imprime as informações da conexão.
     */
    public void imprimeConexao() {
        System.out.println("-----------------------------");
        System.out.println("\tUsuario: " + usuario);
        System.out.println("\tSenha: " + senha);
        System.out.println("\tHost: " + host);
        System.out.println("\tPorta: " + porta);
        System.out.println("\tServiço: " + servico);
        System.out.println("-----------------------------");
        System.out.println();
    }

    /**
     * Retorna o objeto de conexão com o banco de dados.
     *
     * @return O objeto de conexão.
     */
    public Connection retornaConexao() {
        return con;
    }
}