package Database.DAO;
import Database.DatabaseManager;
import Database.Mappers.DeviceMapper;
import Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DeviceDAO {
public Device getDeviceById(int id){
    String sql = "SELECT * FROM Devices WHERE id = ?";
    try (Connection con = DatabaseManager.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)){
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return DeviceMapper.map(rs);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return null;
}
    public static List<Device> getDevicesByRoom(int roomId){
        List<Device> devices = new ArrayList<>();
        String sql =
                "SELECT d.* FROM RoomDevices rd " +
                        "JOIN Devices d ON rd.deviceId = d.id " +
                        "WHERE rd.roomId = ?";

        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, roomId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                devices.add(DeviceMapper.map(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }
public List<Device> getAllDevices(){
    List<Device> devices = new ArrayList<>();
    String sql = "SELECT * FROM Devices";
    try (Connection con = DatabaseManager.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)){
        while (rs.next()){
            devices.add(DeviceMapper.map(rs));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return devices;
}
public boolean updateDeviceStatus(int id, boolean isOn){
    String sql = "UPDATE Devices SET isOn = ? WHERE id = ?";
    try (Connection con = DatabaseManager.getConnection();
    PreparedStatement ps = con.prepareStatement(sql)){
        ps.setBoolean(1,isOn);
        ps.setInt(2,id);
        return ps.executeUpdate()>0;
    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
}
public boolean updateDeviceName(int deviceId, String newName){
    String sql = "UPDATE Devices SET name = ? WHERE id = ?";
    try(Connection con =
            DatabaseManager.getConnection();
    PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1,newName);
        ps.setInt(2,deviceId);
        ps.executeUpdate();
    }catch (SQLException e){
        e.printStackTrace();
    }
    return false;
}
public boolean insertDevice(Device device){
    String sql = "INSERT INTO Devices(name,location,powerUsage,isOn,deviceType,ac_temperature,ac_mode,light_brightness,light_color,door_locked,refrigerator_temperature,refrigerator_doorOpen)"+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    try(Connection con= DatabaseManager.getConnection();

    PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1,device.getName());
        ps.setString(2,device.getLocation());
        ps.setDouble(3,device.getPowerUsage());
        ps.setBoolean(4,device.isOn());
        ps.setString(5, device.getDeviceType());
        ps.setObject(6,device instanceof AC ? ((AC) device).getTemperature():null);
        ps.setObject(7,device instanceof AC ? ((AC) device).getMode():null );
        ps.setObject(8,device instanceof Light ?((Light)device).getBrightness():null);
        ps.setObject(9,device instanceof Light ? ((Light) device).getColor(): null);
        ps.setObject(10,device instanceof Door ? ((Door)device).isLocked():null);
        ps.setObject(11,device instanceof Refrigerator ? ((Refrigerator)device).getTemperature(): null);
        ps.setObject(12,device instanceof Refrigerator ? ((Refrigerator)device).isDoorOpen(): null);
        int affected = ps.executeUpdate();
        if (affected>0){
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                device.setId(rs.getInt(1));
            }
            return true;
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
}
public boolean clearDevicesTable(){
    try(Connection con = DatabaseManager.getConnection();
    Statement st = con.createStatement()){
        st.executeUpdate("DELETE FROM RoomDevices");
        st.executeUpdate("DELETE FROM Devices");
        return true;
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }
}
public boolean clearRoomsTable(){
    try(Connection con = DatabaseManager.getConnection();
    Statement st = con.createStatement()){
        st.executeUpdate("DELETE FROM RoomDevices");
        st.executeUpdate("DELETE FROM Rooms");
        return true;
    }catch (Exception e){
        e.printStackTrace();
        return false;
    }
}
}