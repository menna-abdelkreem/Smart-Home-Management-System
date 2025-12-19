package Database.DAO;
import Database.DatabaseManager;
import Model.User;

import java.sql.*;
import java.time.LocalDateTime;

public class UserDAO {
    public User getUserById(int id){
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (Connection con = DatabaseManager.getConnection();
       PreparedStatement ps =con.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return mapUser(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public User getUserByUserName(String username){
        String sql = "SELECT * FROM Users WHERE username = ?";
        try (Connection con = DatabaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return mapUser(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean insertUser(User user){
        String sql = "INSERT INTO Users (username, password, email, phone,preferredMode,language,notificationsEnable,theme,twoFactorEnabled,lastLogin,role,totalUsageHours,lastUsedDevices, energySavingMode) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection con = DatabaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5,user.getPreferredMode());
            ps.setString(6,user.getLanguage());
            ps.setBoolean(7,user.isNotificationsEnable());
            ps.setString(8,user.getTheme());
            ps.setBoolean(9,user.isTwoFactorEnabled());
            ps.setTimestamp(10,user.getLastLogin()!= null ? Timestamp.valueOf(user.getLastLogin()): null);
            ps.setString(11,user.getRole());
            ps.setDouble(12,user.getTotalUsageHours());
            ps.setString(13,user.getLastUsedDevices());
            ps.setBoolean(14,user.isEnergySavingMode());
            return ps.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private User mapUser(ResultSet rs) throws SQLException{
        return new User(
                rs.getInt("id"),
                rs.getString("Username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("preferredMode"),
                rs.getString("language"),
                rs.getBoolean("notificationsEnable"),
                rs.getString("theme"),
                rs.getBoolean("twoFactorEnabled"),
                rs.getTimestamp("lastLogin") != null?
                        rs.getTimestamp("lastLogin").toLocalDateTime(): null,
                rs.getString("role"),
                rs.getDouble("totalUsageHours"),
                rs.getString("lastUsedDevices"),
                rs.getBoolean("energySavingMode")


        );
    }
}