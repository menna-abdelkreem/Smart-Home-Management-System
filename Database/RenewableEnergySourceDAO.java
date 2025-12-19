package Database.DAO;

import Database.DatabaseManager;
import Database.Mappers.RenewableEnergySourceMapper;
import Model.RenewableEnergySource;
import Model.SolarPanel;
import Model.WindTurbine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RenewableEnergySourceDAO {
   private final DatabaseManager databaseManager = new DatabaseManager();

   public boolean add(RenewableEnergySource src){
       String sql = "INSERT INTO RenewableEnergySources (id,sourceType,generatedPower,sunlightIntensity,windSpeed) VALUES(?,?,?,?,?)";
       try (Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
           stmt.setString(1,src.getId());
           stmt.setString(2, src.getSourceType());
           stmt.setDouble(3,src.getGeneratedPower());
           if(src instanceof SolarPanel sp){
               stmt.setDouble(4,sp.getSunlightIntensity());
               stmt.setNull(5,Types.FLOAT);
           }else if(src instanceof WindTurbine wt){
               stmt.setNull(4,Types.FLOAT);
               stmt.setDouble(5,wt.getWindSpeed());
           }else {
               stmt.setObject(4,null);
               stmt.setObject(5,null);
           }
           return stmt.executeUpdate()>0;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
   }
   public List<RenewableEnergySource>getAll() {
       String sql = "SELECT * FROM RenewableEnergySources";
       List<RenewableEnergySource> list = new ArrayList<>();
       try (Connection con = DatabaseManager.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
           while (rs.next()) {
               list.add(RenewableEnergySourceMapper.map(rs));
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return list;
   }
   public RenewableEnergySource getById(String id){
       String sql = "SELECT * FROM RenewableEnergySources WHERE id = ?";
       try (Connection con= DatabaseManager.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql)){
       stmt.setString(1,id);
       try(ResultSet rs = stmt.executeQuery()){
           if(rs.next())return RenewableEnergySourceMapper.map(rs);
       }
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
   }
   public boolean updatePower(String id,double newPower){
       String sql = "UPDATE RenewableEnergySources SET generatedPower = ? WHERE id = ? ";
       try(Connection con = DatabaseManager.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql)){
           stmt.setDouble(1,newPower);
           stmt.setString(2,id);
           return stmt.executeUpdate()>0;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
   }
   public boolean delete(String id){
       String sql = "DELETE FROM RenewableEnergySources WHERE id = ?";
       try(Connection con = DatabaseManager.getConnection();
       PreparedStatement stmt = con.prepareStatement(sql)){
           stmt.setString(1,id);
           return stmt.executeUpdate()>0;
       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
   }
    public boolean RenewableEnergySourcesTable(){
        try(Connection con = DatabaseManager.getConnection();
            Statement st = con.createStatement()){
            st.executeUpdate("DELETE FROM RenewableEnergySources");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}