package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private final String serverName = "localhost"; 
    private final String dbName = "xxxx"; //your databaseName
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa"; //your user role
    private final String passwords = "xxxx"; //your local user password

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
