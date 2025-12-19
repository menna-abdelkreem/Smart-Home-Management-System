package Database.Mappers;

import Model.AuditLog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditLogMapper {
    public static AuditLog map (ResultSet rs ) throws SQLException {
        return new AuditLog(
                rs.getInt("id"),
                rs.getObject("userId", Integer.class),
                rs.getString("action"),
                rs.getString("target"),
                rs.getTimestamp("actionTime").toLocalDateTime()
        );
    }
}
