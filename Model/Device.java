package Model;
public abstract  class Device {
    protected int id;
    protected String name;
    protected double powerUsage;
    protected boolean isOn;
    protected String location;
    protected String deviceType;

    public Device(int id, String name, String location, double powerUsage, boolean isOn, String deviceType) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.isOn = isOn;
        this.powerUsage = powerUsage;
        this.deviceType = deviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
public void toggle(){
        this.isOn = !this.isOn;
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(double powerUsage) {
        this.powerUsage = powerUsage;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public abstract String getStatus();

    @Override
    public String toString() {
        return name + "(ID: "+ id + ") - " +(isOn ? "ON" : "OFF") +"- in: " +location;
    }
}
