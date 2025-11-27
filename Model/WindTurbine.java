package Model;

public class WindTurbine extends RenewableEnergySource {
    private double windSpeed;

    public WindTurbine(String id, double windTurbine) {
        super(id);
        this.windSpeed= 0.0;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    @Override
    public void generatePower() {
        generatedPower = windSpeed * 0.25;
    }
}
