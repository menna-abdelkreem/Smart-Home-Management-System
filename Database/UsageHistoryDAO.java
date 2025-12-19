package Database.DAO;

import Database.DatabaseManager;
import Database.Mappers.UsageHistoryMapper;
import Model.UsageHistory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class UsageHistoryDAO {
    public void insert(UsageHistory history) throws SQLException {
        String sql = "INSERT INTO UsageHistory (userId, deviceId, startTime,endTime)VALUES(?,?,?,?)";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1,history.getUserId());
            ps.setInt(2,history.getDeviceId());
            ps.setTimestamp(3, Timestamp.valueOf(history.getStartTime()));
            ps.setTimestamp(4,history.getEndTime()!=null ? Timestamp.valueOf(history.getEndTime()):null);
            ps.executeUpdate();
        }
    }
    public void closeLastUsage(int deviceId) throws SQLException{
        String sql = """
                UPDATE UsageHistory SET endTime = ?
                WHERE deviceId = ? AND endTime IS NULL
                """;
        try(Connection con = DatabaseManager.getConnection();
        PreparedStatement ps =
                con.prepareStatement(sql)){
            ps.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(2,deviceId);
            ps.executeUpdate();
        }
    }
    public List<UsageHistory> getAll() throws SQLException{
        List<UsageHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM UsageHistory";
        try (Connection con = DatabaseManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)){
            while (rs.next()){
                list.add(UsageHistoryMapper.map(rs));
            }
        }
        return list;
    }
}
