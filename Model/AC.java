package Model;

public class AC extends Device{
    private double temperature;
    private String mode;

    public AC(int id, String name, String location, double powerUsage, boolean isOn, double temperature, String mode) {
        super(id, name, location, powerUsage, isOn, "AC");
        this.temperature = temperature;
        this.mode = mode;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature < 16){
            temperature = 16;
        }
        if (temperature > 30){
            temperature = 30;
        }
        this.temperature = temperature;
    }
     public void increaseTemp(){
        if (temperature <30){
            temperature++;
        }
     }
     public void decreaseTemp(){
        if (temperature > 16){
            temperature--;
        }
     }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String getStatus() {
        return "AC: "+ getName()+ "|"+ (isOn() ? "ON" : "OFF")+
                "| Temp: "+
                temperature + "˚c | Mode: " +mode;
    }
}
