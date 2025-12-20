package GUI.controllers;

import Model.RenewableEnergySource;
import Model.SolarPanel;
import Model.WindTurbine;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class EnergyCardController {
    @FXML
    private Label lblType;
    @FXML
    private Label lblId;
    @FXML
    private Label lblPower;
    @FXML
    private  Label lblExtra;
    public void setData(RenewableEnergySource src){
        lblType.setText(src.getSourceType());
        lblId.setText("ID: " +src.getId());
        lblPower.setText("Generated Power: "+src.getGeneratedPower()+"KW");
        if (src instanceof SolarPanel sp){
            lblExtra.setText("Sunlight: "+sp.getSunlightIntensity());
        }else if (src instanceof WindTurbine wt){
            lblExtra.setText("WindSpeed: "+ wt.getWindSpeed());
        }else {
            lblExtra.setText("");
        }
    }
}
