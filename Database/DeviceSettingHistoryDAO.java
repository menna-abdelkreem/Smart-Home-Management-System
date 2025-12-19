package Database.DAO;

import Database.DatabaseManager;
import Database.Mappers.DeviceSettingHistoryMapper;
import Model.DeviceSettingHistory;
    import Model.Refrigerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceSettingHistoryDAO {
    public void  insert(DeviceSettingHistory history) throws SQLException{
        String sql = "INSERT INTO DeviceSettingHistory (deviceId, settingName, oldValue, newValue, changeAt) VALUES (?,?,?,?,?)";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            String checkDevice = "SELECT id FROM Devices WHERE id = ? ";
            try(PreparedStatement checkPs =
                        con.prepareStatement(checkDevice)){
                checkPs.setInt(1,history.getDeviceId());
                try(ResultSet rs = checkPs.executeQuery()){
                    if(!rs.next()){
                        throw new SQLException("Device ID " + "does not exist in Devices table. ");
                    }
                }
            }
            ps.setInt(1,history.getDeviceId());
            ps.setString(2,history.getSettingName());
            ps.setString(3,history.getOldValue());
            ps.setString(4,history.getNewValue());
            ps.setTimestamp(5, Timestamp.valueOf(history.getChangeAt()));
            ps.executeUpdate();
        }
    }

    public List<DeviceSettingHistory> getAll() throws SQLException{
        List<DeviceSettingHistory>list= new ArrayList<>();
        String sql = "SELECT * FROM DeviceSettingHistory";
        try(Connection con = DatabaseManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)){
                while (rs.next()){
                    list.add(DeviceSettingHistoryMapper.map(rs));
                }
        }
        return list;
    }
}
