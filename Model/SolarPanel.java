package Model;
public class SolarPanel extends RenewableEnergySource {
    public SolarPanel(String id,String sourceType,double generatedPower, double sunlightIntensity) {
        super(id,"SOLAR",generatedPower);
        this.sunlightIntensity = sunlightIntensity;
    }
    @Override
    public void generatePower() {
        if (sunlightIntensity != null){
            generatedPower = sunlightIntensity * 0.15;
        }
    }
}
