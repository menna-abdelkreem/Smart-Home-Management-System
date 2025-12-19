package Database.DAO;
import Database.DatabaseManager;
import Database.Mappers.AuditLogMapper;
import Model.AuditLog;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuditLogDAO {
    public void insert(AuditLog log) throws SQLException{
        String sql = "INSERT INTO AuditLogs(userId,action,target,actionTime)VALUES(?,?,?,?)";

        try (Connection  con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            if (log.getUserId() == null)
                ps.setNull(1, Types.INTEGER);
            else
                ps.setInt(1,log.getUserId());
            ps.setString(2,log.getAction());
            ps.setString(3,log.getTarget());
            ps.setTimestamp(4, Timestamp.valueOf(log.getActionTime()));
            ps.executeUpdate();
        }
    }
    public List<AuditLog>getAll() throws SQLException{
        List<AuditLog>list = new ArrayList<>();
        String sql = "SELECT * FROM AuditLogs";
        try(Connection con =
                DatabaseManager.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)){
            while (rs.next()){
                list.add(AuditLogMapper.map(rs));
            }
        }
        return list;
    }
}
