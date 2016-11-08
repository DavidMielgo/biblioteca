package pkgConexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clConexionSingleton {

    private static clConexionSingleton instance = null;
    private Connection connection = null;
    private ResultSet result = null;

    protected clConexionSingleton() throws SQLException {
        String sUrl = "jdbc:mysql://localhost:3306/biblioteca";
        connection = DriverManager.getConnection(sUrl, "root", "");
    }

    public static clConexionSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new clConexionSingleton();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        result = stmt.executeQuery(sql);
        
        return result; 
    }

    public void executeSqlUpdate(String sql) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
    }
}
