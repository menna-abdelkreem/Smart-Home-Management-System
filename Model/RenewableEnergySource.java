package Model;

public abstract class RenewableEnergySource {
    protected String id;
    protected String sourceType;
    protected double generatedPower;
    protected Double sunlightIntensity = null;
    protected Double windSpeed = null;

    public RenewableEnergySource(String id, String sourceType, double generatedPower) {
        this.id = id;
        this.generatedPower = generatedPower;
        this.sourceType = sourceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public double getGeneratedPower() {
        return generatedPower;
    }

    public void setGeneratedPower(double generatedPower) {
        this.generatedPower = generatedPower;
    }

    public Double getSunlightIntensity() {
        return sunlightIntensity;
    }

    public void setSunlightIntensity(Double sunlightIntensity) {
        this.sunlightIntensity = sunlightIntensity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public abstract void generatePower();

    @Override
    public String toString() {
        return "Energy source ID: " + id + "| Power: " +
                generatedPower + "KW";
    }

}


