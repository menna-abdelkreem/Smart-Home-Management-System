package GUI.controllers;

import Database.DAO.DeviceDAO;
import Database.DAO.RoomDAO;
import GUI.navigation.SceneManager;
import Model.DataReceiver;
import Model.Device;
import Model.Room;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import java.util.List;

public class DeviceController implements DataReceiver {
    private Room currentRoom;
    @Override
    public void receiveData (Object data){
        if (data instanceof Room){
            currentRoom = (Room) data;
            loadDevices();
        }
    }
    public void loadDevices(){
        devicesContainer.getChildren().clear();
        List<Device> devices = deviceDAO.getDevicesByRoom(currentRoom.getId());
        for (Device d : devices){
            devicesContainer.getChildren().add(createDeviceCard(d));
        }
    }
    @FXML
    private FlowPane devicesContainer;
    DeviceDAO deviceDAO = new DeviceDAO();
    @FXML
    private void goToDashboard(){
        SceneManager.switchTo("dashboard.fxml");
    }
    @FXML
    private void goBack(){
        SceneManager.switchTo("rooms.fxml");
    }
    @FXML
    public void initialize() {
        List<Device> devices = deviceDAO.getAllDevices();
        for (Device device : devices) {
            devicesContainer.getChildren().add(createDeviceCard(device));
        }
    }
    public VBox createDeviceCard(Device device){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/GUI/components/device_card.fxml"));
            VBox card = loader.load();
            DeviceCardController controller = loader.getController();
            controller.setDevice(device);
            return card;
        }catch (Exception e){
            e.printStackTrace();
            return new VBox();
        }
    }
}
