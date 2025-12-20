package GUI.controllers;

import Database.DAO.DeviceDAO;
import Model.Device;
import Services.AutomationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.time.zone.ZoneRulesProvider.refresh;

public class DeviceCardController {
    @FXML
    private Label nameLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Button toggleBtn;
    @FXML
    private Label statusLabel;
    @FXML
    private VBox detailsBox;
    private Device device;
    private DeviceDAO deviceDAO = new DeviceDAO();
    public void setDevice(Device device){
      this.device = device;
     nameLabel.setText(device.getName());
     typeLabel.setText(device.getDeviceType());
     updateStatus();
    }
    private final AutomationService automationService = new AutomationService();
    private final int CURRENT_USER_ID = 1;
    @FXML
    private void toggleDevice(){
       boolean wasOn =device.isOn();
       device.setOn(!wasOn);
       deviceDAO.updateDeviceStatus(device.getId(), device.isOn());
       if (device.isOn()){
           automationService.startDevice(CURRENT_USER_ID, device.getId());
       }else {
           automationService.stopDevice(device.getId(),CURRENT_USER_ID);
       }
       updateStatus();
    }
    private void updateStatus(){
        statusLabel.setText(device.isOn()? "ON" : "OFF");
        toggleBtn.setText(device.isOn() ? "Turn OFF" : "Turn ON");
    }
    @FXML
    private Button settingsButton;
    @FXML
    private void openSettings(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/views/settings.fxml"));
            Parent root = loader.load();
            DeviceSettingsController controller = loader.getController();
            controller.setDevice(device);
            Stage stage = new Stage();
            stage.setTitle("Device Settings");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
