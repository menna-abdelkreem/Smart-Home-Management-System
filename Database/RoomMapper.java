package Database.Mappers;


import Model.Room;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomMapper {
    public static Room map(ResultSet rs)throws SQLException {
        Room r = new Room();
        r.setId(rs.getInt("id"));
        r.setName(rs.getString("name"));
        r.setFloor(rs.getString("floor"));
        return r;
    }
}