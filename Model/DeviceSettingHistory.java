package Model;

import java.time.LocalDateTime;

public class DeviceSettingHistory {
    private int id;
    private int deviceId;
    private String settingName;
    private String oldValue;
    private String newValue;
    private LocalDateTime changeAt;
    public DeviceSettingHistory(int id,int deviceId, String settingName, String oldValue, String newValue,LocalDateTime changeAt){
        this.id= id;
        this.deviceId=deviceId;
        this.settingName =settingName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeAt = changeAt;
    }
    public DeviceSettingHistory(int deviceId, String settingName, String oldValue, String newValue, LocalDateTime changeAt){
        this.deviceId = deviceId;
        this.settingName = settingName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.changeAt = changeAt;
    }

    public int getId() {
        return id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getSettingName() {
        return settingName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public LocalDateTime getChangeAt() {
        return changeAt;
    }
}
