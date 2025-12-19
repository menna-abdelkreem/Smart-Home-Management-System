package Database;
public class DBConfig {
  public static final String SERVER_NAME = "localhost";
  public static final String DATABASE_NAME = "SmartHomeDB";
  public static final boolean USE_WINDOWS_AUTH=true;
  public static final boolean ENCRYPT =true;
  public static final boolean TRUST_SERVER_CERTIFICATE = true;
  public static String getConnectionURL(){
      String url ="jdbc:sqlserver://"+ SERVER_NAME+":1433;databaseName="+DATABASE_NAME;
      if(USE_WINDOWS_AUTH){
          url +=";integratedSecurity=true";
      }
      if(ENCRYPT){
          url +=";encrypt=true";
      }
      if(TRUST_SERVER_CERTIFICATE){
          url += ";trustServerCertificate=true";
      }
      return url;
  }
}

