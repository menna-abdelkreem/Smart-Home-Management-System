package Model;

public abstract  class Device {
    protected int id;
    protected String name;
    protected double powerUsage;
    protected boolean isOn;
    protected String location;

    public Device(int id, String name, String location, double powerUsage) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.isOn = false;
        this.powerUsage = powerUsage;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public void toggle() {
        this.isOn = !this.isOn;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }
    public double getPowerUsage() {
        return powerUsage;
    }

    public abstract String getStatus();

    @Override
    public String toString() {
        return name + "(ID: " + id + ")-" +(isOn ? "ON" : "OFF")+
                "-in :" +location;
    }

}
