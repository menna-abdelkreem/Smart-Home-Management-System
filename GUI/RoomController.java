package GUI.controllers;

import Database.DAO.RoomDAO;
import GUI.navigation.SceneManager;
import Model.Room;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.List;

public class RoomController {
    @FXML
    private void openRoomDevices(){
        SceneManager.switchTo("devices.fxml");
    }
    @FXML
    private void goToDashboard(){
        SceneManager.switchTo("dashboard.fxml");
    }
    @FXML
    private FlowPane roomsContainer;
    private final RoomDAO roomDAO = new RoomDAO();
    public void initialize(){
        RoomDAO dao = new RoomDAO();
        List<Room> rooms = dao.getAllRoomsWithDevices();
        roomsContainer.getChildren().clear();
        for (Room room : rooms){
            createRoomCard(room);
        }
        FadeTransition ft = new FadeTransition(Duration.millis(600),roomsContainer);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        loadRooms();
    }
    private void loadRooms(){
        roomsContainer.getChildren().clear();
        List<Room> rooms = roomDAO.getAllRoomsWithDevices();
        for (Room room : rooms){
            VBox roomCard = createRoomCard(room);
            roomsContainer.getChildren().add(roomCard);
        }
    }
    @FXML
    private VBox createRoomCard(Room room){
        VBox card = new VBox(10);
        card.getStyleClass().add("room-card");
        Label name = new Label(room.getName());
        name.getStyleClass().add("room-name");
        Label devices = new Label("Devices: " + room.getDevices().size());
        devices.getStyleClass().add("room-devices");
        Button openBtn = new Button("Open");
        openBtn.getStyleClass().add("secondary-btn");
        Button deleteBtn = new Button("Delete");
        deleteBtn.getStyleClass().add("secondary-btn");
        openBtn.setOnAction(e ->  openRoomDevices());
        deleteBtn.setOnAction(e -> {
            RoomDAO dao = new RoomDAO();
            boolean deleted = dao.deleteRoom(room.getId());
            if (deleted){
                roomsContainer.getChildren().remove(card);
            }
                });
        card.getChildren().addAll(name, devices,openBtn,deleteBtn);
        return card;
    }
    @FXML
    private void openAddRoomDialog(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Room");
        dialog.setHeaderText("Create New Room");
        dialog.setContentText("Room name: ");
        dialog.showAndWait().ifPresent(name -> {
         Room room = new Room();
         room.setName(name);
         room.setFloor("1");
         if (roomDAO.addRoom(room)){
             loadRooms();
         }
        });
    }
}
