package Model;

public class Refrigerator extends Device{
    private double temperature;
    private boolean doorOpen;
    public  Refrigerator(int id, String name, String location, double powerUsage, boolean isOn, double temperature, boolean doorOpen){
        super(id, name, location, powerUsage, isOn,"Refrigerator");
        this.temperature = temperature;
        this.doorOpen = doorOpen;
    }
        public  void openDoor(){
        doorOpen = true;
        }
        public void closeDoor(){
        doorOpen = false;
        }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature < -5){
            temperature = - 5;
        }
        if (temperature > 10){
            temperature = 10;
        }
        this.temperature = temperature;
    }

    @Override
    public String getStatus() {
        return "Refrigerator: "+ getName() + "|" + "Temp: " + temperature + "˚c| Door: " + (doorOpen ? "Open" : "Closed");
    }
}
