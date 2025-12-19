package Database.Mappers;

import Model.UsageHistory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsageHistoryMapper {
    public static UsageHistory map(ResultSet rs) throws SQLException{
        return new UsageHistory(
                rs.getInt("id"),
                rs.getInt("userId"),
                rs.getInt("deviceId"),
                rs.getTimestamp("startTime").toLocalDateTime(),
                rs.getTimestamp("endTime")!= null ?
                        rs.getTimestamp("endTime").toLocalDateTime() : null
        );
    }
}
