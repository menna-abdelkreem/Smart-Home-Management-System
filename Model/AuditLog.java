package Model;
import java.time.LocalDateTime;

public class AuditLog {
    private int id;
    private Integer userId;
    private String action;
    private String target;
    private LocalDateTime actionTime;

    public AuditLog(int id, Integer userId, String action, String target, LocalDateTime actionTime){
        this.id =id;
        this.userId =userId;
        this.action =action;
        this.target = target;
        this.actionTime = actionTime;
    }
    public AuditLog(Integer userId, String action, String target){
        this.userId = userId;
        this.action=action;
        this.target=target;
        this.actionTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    public String getTarget() {
        return target;
    }

    public LocalDateTime getActionTime() {
        return actionTime;
    }
}
