package Services;
import Database.DAO.DeviceDAO;
import Database.DAO.RoomDAO;
import Model.Room;

import java.util.List;

public class RoomService {
    private final RoomDAO roomDAO;
    private final DeviceDAO deviceDAO;
    public RoomService() {
        this.roomDAO = new RoomDAO();
        this.deviceDAO = new DeviceDAO();
    }
   public Room getRoomById(int roomId){
        return roomDAO.getRoomByIdWithDevices(roomId);
   }
   public List<Room>getAllRooms(){
        return roomDAO.getAllRoomsWithDevices();
    }
    public boolean createRoom(Room room){
        if(room== null) return false;
        return roomDAO.addRoom(room);
    }
    public boolean deleteRoom(int roomId){
        return roomDAO.deleteRoom(roomId);
    }
    public boolean addDeviceToRoom(int roomId, int deviceId){
        if(roomDAO.getRoomByIdWithDevices(roomId)== null)
            return false;
        if(deviceDAO.getDeviceById(deviceId)== null)
            return false;
        return roomDAO.addDeviceToRoom(roomId,deviceId);
    }
    public boolean removeDeviceFromRoom(int roomId, int deviceId){
        return roomDAO.removeDeviceFromRoom(roomId,deviceId);
    }
    public boolean cleanAllRooms(){
        return roomDAO.clearRoomsTable();
    }
}
