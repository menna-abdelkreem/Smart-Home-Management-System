package Database.Mappers;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
public class UserMapper {
    public static User map(ResultSet rs) throws SQLException{
        User u = new User(
                rs.getInt("id"),
                rs.getString("Username"),
                rs.getString("password"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("preferredMode"),
                rs.getString("language"),
                rs.getBoolean("notificationsEnabled"),
                rs.getString("theme"),
                rs.getBoolean("twoFactorEnabled"),
                rs.getTimestamp("lastLogin") != null?
                        rs.getTimestamp("lastLogin").toLocalDateTime(): null,
                rs.getString("role"),
                rs.getDouble("totalUsageHours"),
                rs.getString("lastUsedDevice"),
                rs.getBoolean("energySavingMode")

        );
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("Username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setPreferredMode(rs.getString("preferredMode"));
        u.setLanguage(rs.getString("language"));
        u.setNotificationsEnable(rs.getBoolean("notification"));
        u.setTheme(rs.getString("theme"));
        u.setTwoFactorEnabled(rs.getBoolean("twoFactorEnabled"));
        u.setLastLogin(LocalDateTime.parse("LastLogin"));
        u.setRole(rs.getString("role"));
        u.setTotalUsageHours(rs.getDouble("totalUsageHours"));
        u.setLastUsedDevice(rs.getString("LastUsedDevice"));
        u.setEnergySavingMode(rs.getBoolean("energySavingMode"));
        return u;
    }
}

