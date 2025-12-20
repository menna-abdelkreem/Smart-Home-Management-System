package Model;

public class Door extends Device{
    private boolean isLocked;
    public Door(int id, String name, String location, double powerUsage,boolean isOn ,boolean isLocked){
        super(id, name, location, powerUsage,isOn,"Door");
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
    public void lock(){
        isLocked = true;
    }
    public void unlock(){
        isLocked = false;
    }

    @Override
    public String getStatus() {
        return "Door: " + getName() + "|" + (isOn ? "Opened" : "Closed") +
                " | Locked: " + ( isLocked ? "Yes" : "No");
    }
}
