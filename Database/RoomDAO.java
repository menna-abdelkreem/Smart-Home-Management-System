package Database.DAO;

import Database.DatabaseManager;
import Database.Mappers.DeviceMapper;
import Model.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
    public  static List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Rooms";
        try (Connection con = DatabaseManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            while (rs.next()){
                rooms.add(new Room(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("floor")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rooms;
    }
    public boolean addRoom(Room room){
        String sql = "INSERT INTO Rooms (name,floor) VALUES ( ?, ?)";
        try(Connection con = DatabaseManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
           ps.setString(1,room.getName());
           ps.setString(2,room.getFloor());
           int affected = ps.executeUpdate();
           if(affected>0) {
               ResultSet rs = ps.getGeneratedKeys();
               if (rs.next()) {
                   room.setId(rs.getInt(1));
               }
               return true;
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteRoom(int roomId){
        String sql = "DELETE FROM ROOMS WHERE id = ?";
        try(Connection con = DatabaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,roomId);
            return ps.executeUpdate()>0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Room getRoomByIdWithDevices(int roomId){
        Room room = null;
        String sqlRoom = "SELECT * FROM Rooms WHERE id = ?";
        String sqlDevices =
                "SELECT d.* FROM RoomDevices rd " +
                        "JOIN Devices d ON rd.deviceId = d.id " +
                        "WHERE rd.roomId = ?";
        try(Connection con = DatabaseManager.getConnection();
        PreparedStatement psRoom = con.prepareStatement(sqlRoom);
        PreparedStatement psDevice = con.prepareStatement(sqlDevices)){
            psRoom.setInt(1,roomId);
            ResultSet rsRoom = psRoom.executeQuery();
            if(rsRoom.next()){
                room = new Room(rsRoom.getInt("id"),
                        rsRoom.getString("name"),
                        rsRoom.getString("floor"));
            }
            if (room != null){
                psDevice.setInt(1,roomId);
                ResultSet rsDevices = psDevice.executeQuery();
                while (rsDevices.next()){
                    room.addDevice(DeviceMapper.map(rsDevices));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return room;
    }
    public List<Room> getAllRoomsWithDevices(){
        List<Room>rooms=getAllRooms();
        for (Room room: rooms){
            Room fullRoom = getRoomByIdWithDevices(room.getId());
            room.getDevices().addAll(fullRoom.getDevices());
        }
        return rooms;
    }
    public boolean addDeviceToRoom(int roomId,int deviceId){
        String sql = "INSERT INTO RoomDevices(roomId,deviceId)VALUES(?,?)";
        try (Connection con = DatabaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,roomId);
            ps.setInt(2,deviceId);
            return ps.executeUpdate()>0;
        }catch (Exception e){
            return false;
        }
    }
    public boolean removeDeviceFromRoom(int roomId,int deviceId){
        String sql = "DELETE FROM RoomDevices WHERE roomId = ? AND deviceId = ?";
        try(Connection con = DatabaseManager.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,roomId);
            ps.setInt(2,deviceId);
            return ps.executeUpdate()>0;
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
