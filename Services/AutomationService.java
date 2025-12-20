package Services;

import Database.DAO.AuditLogDAO;
import Database.DAO.DeviceSettingHistoryDAO;
import Database.DAO.UsageHistoryDAO;
import Model.AuditLog;
import Model.DeviceSettingHistory;
import Model.UsageHistory;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class AutomationService {
    private final UsageHistoryDAO usageHistoryDAO = new UsageHistoryDAO();
    private DeviceSettingHistoryDAO deviceSettingHistoryDAO = new DeviceSettingHistoryDAO();
    private final AuditLogDAO auditLogDAO = new AuditLogDAO();
    public void startDevice(int userId, int deviceId){
        try {
            usageHistoryDAO.insert(new UsageHistory(userId, deviceId));
            auditLogDAO.insert(new AuditLog(userId,"DEVICE_STARTED","Device ID: "+ deviceId));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void stopDevice(int deviceId, Integer userId){
        try {
            usageHistoryDAO.closeLastUsage(deviceId);
            auditLogDAO.insert(new AuditLog(userId,"DEVICE_STOPPED","Device ID: " + deviceId));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void changeDeviceSetting(
            int deviceId,
            String setting,
            String oldValue,
            String newValue,
            Integer userId
    ){
        try {
            DeviceSettingHistory history = new DeviceSettingHistory(deviceId,setting,oldValue,newValue, LocalDateTime.now());
            deviceSettingHistoryDAO.insert(history);
            auditLogDAO.insert(new AuditLog(userId,"SETTING_CHANGED","Device" + deviceId + " : " + setting));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
