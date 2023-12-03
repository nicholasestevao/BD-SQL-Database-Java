package sistemaplanetario;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.lang.ClassNotFoundException;

public class Conexao {
    private Connection con;
    private Statement statement;

    private String host;
    private int porta;
    private String servico;
    private String usuario;
    private String senha;

    public Conexao(String host, int porta, String servico, String usuario, String senha){
        this.host = host;
        this.porta = porta;
        this.servico = servico;
        this.usuario = usuario;
        this.senha = senha;

        con = null;
        statement = null;
    }

    public boolean estaConectado() throws SQLException{
        if(con == null)
            return false;

        return con.isValid(10);
    }

    public void iniciaConexao() throws SQLException{
        if(estaConectado()){
            System.out.println("Usuário " + usuario + "já está conectado!");
            return;
        }

        System.out.println("Iniciando conexão...");

        try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
        }
        catch(ClassNotFoundException e){
            System.out.println("ERRO: não foi possível abrir a biblioteca JDBC. Verifique o arquivo ojdbc11.jar.");
            System.out.println(e.getMessage());
        }

        String url = "jdbc:oracle:thin:@"+ host + ":" + porta + "/" + servico;
        System.out.println("URL: " + url);
        DriverManager.setLoginTimeout(5);
        con = DriverManager.getConnection(url, usuario, senha);
        statement = con.createStatement();

        System.out.println("Você foi conectado!");
        
    } 

    public void fechaConexao() throws SQLException{
        if(!estaConectado()){
            System.out.println("Usuário " + usuario + " não está conectado!");
            return;
        }
        con.close();
    }

    public ResultSet executaLinhaSQL(String linha) throws SQLException{
        if(con == null)
            return null;
        
        ResultSet resultSet = statement.executeQuery(linha);
        return resultSet;
    }

    public void imprimeConexao(){
        System.out.println("-----------------------------");
        System.out.println("\tUsuario: " + usuario);
        System.out.println("\tSenha: " + senha);
        System.out.println("\tHost: " + host);
        System.out.println("\tPorta: " + porta);
        System.out.println("\tServiço: " + servico);
        System.out.println("-----------------------------");
        System.out.println();
    }
    
    public Connection retornaConexao(){
        return con;
    }
}
