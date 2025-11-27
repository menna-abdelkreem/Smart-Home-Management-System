package Model;
public class SolarPanel extends RenewableEnergySource {
    private  double sunlightIntensity;

    public SolarPanel(String id, double sunlightIntensity) {
        super(id);
        this.sunlightIntensity = sunlightIntensity;
    }

    public void setSunlightIntensity(double sunlightIntensity) {
        this.sunlightIntensity = sunlightIntensity;
    }

    public double getSunlightIntensity() {
        return sunlightIntensity;
    }

    @Override
    public void generatePower() {
        generatedPower = sunlightIntensity * 0.15;
    }
}
