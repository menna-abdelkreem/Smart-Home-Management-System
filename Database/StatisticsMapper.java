package Mappers;

import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsMapper {

    public static void mapStatistics(ResultSet rs, User user) throws SQLException {

        user.addUsageHours(rs.getDouble("totalUsageHours"));
        user.setLastUsedDevice(rs.getString("lastUsedDevice"));

        if (rs.getBoolean("energySavingMode")) {
            user.enableEnergySavingMode();
        }
    }
}
