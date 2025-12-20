package GUI.controllers;

import GUI.navigation.SceneManager;
import Services.UserService;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Scanner;

public class LoginController {
    @FXML
    private VBox loginCard;
    @FXML
    public void initialize(){
        FadeTransition fade = new FadeTransition(Duration.seconds(2.2), loginCard);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        TranslateTransition move = new TranslateTransition(Duration.seconds(2.2),loginCard);
        move.setFromY(40);
        move.setToY(0);
        move.play();
        ScaleTransition scale = new ScaleTransition(Duration.millis(150), loginCard);
        scale.setFromX(1);
        scale.setToX(0.95);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        scale.play();
    }
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private final UserService userService = new UserService();
    public LoginController(){
        userService.ensureAdminExists();
    }
    @FXML
    private void handleLogin(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        if(username.isEmpty()||  password.isEmpty()) {
            showAlert("Error", "Please enter username and password");
            return;
        }
           boolean success = userService.login(username,password);
        if(success){
            System.out.println("Login successful for: " + username);
            SceneManager.switchTo("dashboard.fxml");
        }else {
            showAlert("Login Failed","Invalid username or password");
        }
    }
    private void showAlert(String title,String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        }