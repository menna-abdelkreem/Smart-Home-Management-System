package Model;

public class Door extends Device{
    private boolean isLocked;
    public Door(int id, String name, String location, double powerUsage, boolean isLocked){
        super(id, name, location, powerUsage);
        this.isLocked = isLocked;
    }
    public void lock(){
        isLocked = true;
    }
    public  void unlock(){
        isLocked = false;
    }

    @Override
    public String getStatus() {
        return "Door: " + name + "|" + (isOn ? "Opened" : "Closed") +
                " | Locked: " + ( isLocked ? "Yes" : "No");
    }
}

