package Database;

import Mappers.*;
import Model.*;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {

    private Connection conn;

    public DatabaseManager() {
        conn = DBConfig.getConnection();
    }

    // ======================= INSERT USER ===========================
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO Users VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPhone());
        ps.setString(6, user.getRole());
        ps.setString(7, user.getPreferredMode());
        ps.setString(8, user.getLanguage());
        ps.setBoolean(9, user.isNotificationsEnable());
        ps.setString(10, user.getTheme());
        ps.setBoolean(11, user.isTwoFactorEnabled());
        ps.setTimestamp(12, Timestamp.valueOf(user.getLastLogin()));
        ps.setDouble(13, user.getTotalUsageHours());
        ps.setString(14, user.getLastUsedDevice());
        ps.setBoolean(15, user.isEnergySavingMode());
        ps.setBoolean(16, user.isEnergySavingMode());

        ps.executeUpdate();
        ps.close();
    }

    public User authenticate(String username, String password) throws SQLException {
    String sql = "SELECT * FROM Users WHERE username=? AND password=?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, username);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        return UserMapper.map(rs);
    }
    return null;
}

    // ======================= GET USER BY USERNAME ===========================
    public User getUser(String username) throws SQLException {
        String sql = "SELECT * FROM Users WHERE username=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        User user = null;
        if (rs.next()) user = UserMapper.map(rs);

        rs.close();
        ps.close();

        return user;
    }

    // ======================= GET ALL DEVICES ===========================
    public ArrayList<Device> getAllDevices() throws SQLException {

        ArrayList<Device> list = new ArrayList<>();

        String sql = "SELECT * FROM Device";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Device d = DeviceMapper.map(rs);
            list.add(d);
        }

        rs.close();
        ps.close();
        return list;
    }

    // ======================= GET DEVICES IN ROOM ===========================
    public ArrayList<Device> getDevicesInRoom(String roomName) throws SQLException {

        String sql = "SELECT Device.* FROM Device " +
                     "JOIN RoomDevices ON Device.id = RoomDevices.deviceId " +
                     "WHERE RoomDevices.roomName = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, roomName);

        ResultSet rs = ps.executeQuery();

        ArrayList<Device> list = new ArrayList<>();

        while (rs.next()) {
            list.add(DeviceMapper.map(rs));
        }

        rs.close();
        ps.close();
        return list;
    }
}

