package Mappers;

import Model.Room;
import Model.Device;
import java.sql.*;
import java.util.ArrayList;

public class RoomMapper {

    public static Room map(ResultSet rsRoom, ArrayList<Device> devices) throws SQLException {

        Room room = new Room(rsRoom.getString("name"));

        for (Device d : devices) {
            room.adddevice(d);
        }

        return room;
    }
}
