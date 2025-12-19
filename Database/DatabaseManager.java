package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
  public static Connection getConnection() throws SQLException{
      return DriverManager.getConnection(DBConfig.getConnectionURL());
  }
  public void closeConnection(Connection con){
      if(con != null){
          try {
              con.close();
          }catch (SQLException e){
              e.printStackTrace();
          }
      }
  }
}
