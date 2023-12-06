package src.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String url = "jdbc:mysql://localhost:3306/t2";
    private static final String user = "root";
    private static final String password = "Erick23015@";

    private static Connection conexao;

    private ConexaoDB() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.getConnection(url, user, password);
        }
        
        return conexao;
    }
}

