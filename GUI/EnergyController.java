package GUI.controllers;

import Database.DAO.RenewableEnergySourceDAO;
import GUI.navigation.SceneManager;
import Model.RenewableEnergySource;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class EnergyController {
    @FXML
    private FlowPane energyContainer;
    private final RenewableEnergySourceDAO dao = new RenewableEnergySourceDAO();
    @FXML
    public void initialize(){
        loadEnergySource();
    }
    @FXML
    private void goBack(){
        SceneManager.switchTo("dashboard.fxml");
    }
    public void loadEnergySource(){
        energyContainer.getChildren().clear();
        List<RenewableEnergySource> sources = dao.getAll();
        for(RenewableEnergySource src : sources){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/components/EnergyCard.fxml"));
                VBox card = loader.load();
                EnergyCardController controller = loader.getController();
                controller.setData(src) ;
                energyContainer.getChildren().add(card);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
