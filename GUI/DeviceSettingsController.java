package GUI.controllers;

import Database.DAO.DeviceDAO;
import GUI.navigation.SceneManager;
import Model.Device;
import Services.AutomationService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class DeviceSettingsController {
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> modeBox;
    private Device device;
    private final DeviceDAO deviceDAO = new DeviceDAO();
    private final AutomationService automationService = new AutomationService();
    private final int CURRENT_USER_ID = 1;
    @FXML
    public void initialize(){
        modeBox.getItems().addAll("AUTO","MANUAL","ECO");
    }
    public void setDevice(Device device){
       this.device = device;
       nameField.setText(device.getName());
       modeBox.setValue("AUTO");
        }
        @FXML
    private void saveSettings(){
        String oldName = device.getName();
        String newName = nameField.getText();
        if (!oldName.equals(newName)){
            deviceDAO.updateDeviceName(device.getId(),newName);
            automationService.changeDeviceSetting(device.getId(),"Name",oldName,newName,CURRENT_USER_ID);
            device.setName(newName);
        }
        String oldMode = "AUTO";
        String newMode = modeBox.getValue();
        if (!oldMode.equals(newMode)){
            automationService.changeDeviceSetting(device.getId(), "Mode",oldMode,newMode,CURRENT_USER_ID);
        }
    }
}
