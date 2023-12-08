package sistemaplanetario;
import java.sql.*;

public class DML {
    String select;
    String from;
    String where;
    Conexao conexao;

    public DML(String select, String from, String where, Conexao conexao){
        this.select = select;
        this.from = from;
        this.where = where;
        this.conexao = conexao;
    }

    public static ResultSet consultar(String select, String from, String where, Conexao conexao){
        ResultSet resultado;

        return resultado;
    }



}
