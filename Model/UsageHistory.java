package Model;

import java.time.LocalDateTime;

public class UsageHistory {
    private int id;
    private int userId;
    private int deviceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public UsageHistory(int id, int userId, int deviceId, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.userId =userId;
        this.deviceId =deviceId;
        this.startTime = startTime;
        this.endTime =endTime;
    }
    public UsageHistory(int userId, int deviceId){
        this.userId = userId;
        this.deviceId =deviceId;
        this.startTime = LocalDateTime.now();
    }
    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
