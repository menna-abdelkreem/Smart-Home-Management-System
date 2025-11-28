
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=SmartHome;encrypt=false;";

    private static final String USER = "javauser";   // SQL User
    private static final String PASS = "123456";     // SQL Password

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected Successfully!");
            return conn;
        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}

