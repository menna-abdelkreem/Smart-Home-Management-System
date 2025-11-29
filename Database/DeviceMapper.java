package Mappers;

import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceMapper {

    public static Device map(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String name = rs.getString("name");
        String location = rs.getString("location");
        double powerUsage = rs.getDouble("powerUsage");
        String type = rs.getString("type");

        switch (type) {

            case "LIGHT":
                return new Light(
                        id,
                        name,
                        location,
                        powerUsage,
                        rs.getInt("brightness"),
                        rs.getString("color")
                );

            case "AC":
                return new AC(
                        id,
                        name,
                        location,
                        powerUsage,
                        rs.getDouble("temperature"),
                        rs.getString("mode")
                );

            case "REFRIGERATOR":
                return new Refrigerator(
                        id,
                        name,
                        location,
                        powerUsage,
                        rs.getDouble("temperature"),
                        rs.getBoolean("doorOpen")
                );

            case "DOOR":
                return new Door(
                        id,
                        name,
                        location,
                        powerUsage,
                        rs.getBoolean("isLocked")
                );

            default:
                throw new SQLException("Unknown Device Type: " + type);
        }
    }
}
