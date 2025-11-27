package Model;

import java.util.ArrayList;

public class Room {
    private  String name;
    private ArrayList<Device> devices;
    public Room (String name){
        this.name = name;
        devices = new ArrayList<>();
    }
    public void adddevice(Device device){
        devices.add(device);
    }
    public void removeDevice(int deviceId){
        devices.removeIf(d -> d.getId() == deviceId);
    }
    public  ArrayList<Device>getDevices(){
        return devices;
    }

    @Override
    public String toString() {
        return "Room{name='" +
                name + "',devices=" +
                 devices.size()+ "}";
    }
}
