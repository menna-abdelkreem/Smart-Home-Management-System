package Main;

import GUI.navigation.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
        SceneManager.init(stage);
        SceneManager.switchTo("login.fxml");
        stage.setTitle("Smart Home Management System");
        stage.setWidth(1100);
        stage.setHeight(700);
        stage.setMinWidth(900);
        stage.setMinHeight(600);

        stage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
