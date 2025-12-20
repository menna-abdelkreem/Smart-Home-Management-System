package GUI.controllers;

import Database.DAO.AuditLogDAO;
import GUI.navigation.SceneManager;
import Model.AuditLog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class LogController {
    @FXML
    private TableView<AuditLog> logsTable;
    @FXML
    private TableColumn<AuditLog,Integer> idCol;
    @FXML
    private TableColumn<AuditLog,Integer> userCol;
    @FXML
    private TableColumn<AuditLog,Integer> actionCol;
    @FXML
    private TableColumn<AuditLog,String> targetCol;
    @FXML
    private  TableColumn<AuditLog,String> dateCol;
    private final AuditLogDAO auditLogDAO = new AuditLogDAO();
    @FXML
    public void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));
      targetCol.setCellValueFactory(new PropertyValueFactory<>("target"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("actionTime"));
        loadLogs();
    }
    private void loadLogs(){
        try {
            logsTable.setItems(FXCollections.observableArrayList(auditLogDAO.getAll()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void goBack(){
        SceneManager.switchTo("dashboard.fxml");
    }
}
