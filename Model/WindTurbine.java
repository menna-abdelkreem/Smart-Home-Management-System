package Model;

public class WindTurbine extends RenewableEnergySource {

    public WindTurbine(String id,String sourceType,double generatedPower,double windSpeed) {
        super(id,"WIND",generatedPower);
        this.windSpeed= windSpeed;
    }

    @Override
    public void generatePower() {
        if (windSpeed != null){
            generatedPower = windSpeed * 0.25;
        }
    }
}
