package GUI.controllers;

import Database.DAO.DeviceDAO;
import Database.DAO.RenewableEnergySourceDAO;
import Database.DAO.RoomDAO;
import GUI.navigation.SceneManager;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class DashboardController {
    @FXML
    private Label devicesCountLbl;
    @FXML
    private Label roomsCountLbl;
    @FXML
    private Label energyStatusLbl;
    private final DeviceDAO deviceDAO = new DeviceDAO();
    private final RoomDAO roomDAO = new RoomDAO();
    private final RenewableEnergySourceDAO renewableEnergySourceDAO = new RenewableEnergySourceDAO();
    @FXML
    private void goToRooms(){
        SceneManager.switchTo("rooms.fxml");
    }
    @FXML
    private void goToDevices(){
        SceneManager.switchTo("devices.fxml");
    }
    @FXML
    private void goToLogs(){
        SceneManager.switchTo("logs.fxml");
    }
    @FXML
    private void goToEnergy(){
        SceneManager.switchTo("energy.fxml");
    }

    @FXML
    private VBox content;
    @FXML
    public void animateContent() {
        FadeTransition fade = new FadeTransition(Duration.seconds(1.2), content);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        TranslateTransition slide = new TranslateTransition(Duration.seconds(1.2), content);
        slide.setFromY(20);
        slide.setToY(0);
        slide.play();
    }
    public void  initialize(){
        animateContent();
        loadDashboardData();
    }
    public void loadDashboardData(){
        try {
            int devicesCount = deviceDAO.getAllDevices().size();
            int roomsCount = roomDAO.getAllRooms().size();
            devicesCountLbl.setText(String.valueOf(devicesCount));
            roomsCountLbl.setText(String.valueOf(roomsCount));
            double totalEnergy = renewableEnergySourceDAO.getAll().stream().mapToDouble(e ->e.getGeneratedPower()).sum();
            energyStatusLbl.setText(totalEnergy > 100 ? "High": totalEnergy > 50 ? "Medium" : "Low");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
