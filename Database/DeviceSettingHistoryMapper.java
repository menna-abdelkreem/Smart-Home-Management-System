package Database.Mappers;

import Model.DeviceSettingHistory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceSettingHistoryMapper {
    public static DeviceSettingHistory  map(ResultSet rs) throws SQLException{
        return new DeviceSettingHistory(
                rs.getInt("id"),
                rs.getInt("deviceId"),
                rs.getString("settingName"),
                rs.getString("oldValue"),
                rs.getString("newValue"),
                rs.getTimestamp("changeAt").toLocalDateTime()
        );
    }
}
