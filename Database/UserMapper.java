
package Mappers;

import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User map(ResultSet rs) throws SQLException {

        User user = new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("role")
        );

        user.setPreferredMode(rs.getString("preferredMode"));
        user.setLanguage(rs.getString("language"));
        user.setNotificationsEnable(rs.getBoolean("notificationsEnabled"));
        user.setTheme(rs.getString("theme"));
        user.setTwoFactorEnabled(rs.getBoolean("twoFactorEnabled"));
        user.setLastUsedDevice(rs.getString("lastUsedDevice"));
        user.addUsageHours(rs.getDouble("totalUsageHours"));

        user.enableEnergySavingMode(); //  energySavingMode = true
        return user;
    }
}

