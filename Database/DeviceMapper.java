package Database.Mappers;

import Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceMapper {
public static Device map(ResultSet rs) throws SQLException{
int id = rs.getInt("id");
String name = rs.getString("name");
String location = rs.getString("location");
double powerUsage = rs.getDouble("powerUsage");
boolean isOn = rs.getBoolean("isOn");
String type = rs.getString("deviceType");
switch (type.toUpperCase()){
    case "LIGHT":
        return  new Light(
                id,
                name,
                location,
                powerUsage,
                isOn,
                rs.getInt("light_brightness"),
                rs.getString("light_color")
        );
    case "AC":
        return new AC(
                id,
                name,
                location,
                powerUsage,
                isOn,
                rs.getDouble("ac_temperature"),
                rs.getString("ac_mode")
        );
    case "DOOR":
        return new Door(
                id,
                name,
                location,
                powerUsage,
                isOn,
                rs.getBoolean("door_locked")
        );
    case "REFRIGERATOR":
        return new Refrigerator(
                id,
                name,
                location,
                powerUsage,
                isOn,
                rs.getDouble("refrigerator_temperature"),
                rs.getBoolean("refrigerator_doorOpen")
        );
    default:
        return new Device(
                id,
                name,
                location,
                powerUsage,
                isOn,
                type
        ) {
            @Override
            public String getStatus() {

                return isOn? "ON" : "OFF";
            }
        };

     }

    }
}
