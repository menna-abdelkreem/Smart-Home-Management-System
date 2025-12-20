package GUI.navigation;

import GUI.controllers.DeviceController;
import Model.DataReceiver;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage mainStage;
    public static void init(Stage stage){
        mainStage = stage;
    }
    public static void switchTo(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/GUI/views/"+fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(SceneManager.class.getResource("/GUI/styles/main.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.setResizable(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void switchToWithData(String fxml, Object data){
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/GUI/views/"+fxml));
            Parent root = loader.load();
          if (data != null){
          Object controller = loader.getController();
          if (controller instanceof DataReceiver){
              ((DataReceiver) controller).receiveData(data);
          }
          }
            Scene scene = new Scene(root);
            scene.getStylesheets().add(SceneManager.class.getResource("/GUI/styles/main.css").toExternalForm());
            mainStage.setScene(scene);
            mainStage.setResizable(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        }
    }

