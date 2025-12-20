package Services;

import Database.DAO.AuditLogDAO;
import Model.AuditLog;

import java.sql.SQLException;
import java.util.List;

public class SecurityService {
private  final AuditLogDAO auditLogDAO = new AuditLogDAO();
public void logAction(Integer userId, String action, String target){
    try{
        AuditLog log = new AuditLog(userId,action,target);
        auditLogDAO.insert(log);
    }catch (SQLException e){
        e.printStackTrace();
    }
}
public List<AuditLog> getAllLogs(){
    try{
        return auditLogDAO.getAll();
    }catch (SQLException e){
        e.printStackTrace();
        return List.of();
    }
}
}
