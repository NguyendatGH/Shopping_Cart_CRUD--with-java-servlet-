package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private final String serverName = "localhost"; 
    private final String dbName = "ShoppingCartDB";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String passwords = "admin2404";

    public Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        } else {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      
        return DriverManager.getConnection(url, userID, passwords);
    }
    public static void main(String[] args) {
        System.out.println("connect Success");
    }
  
}
