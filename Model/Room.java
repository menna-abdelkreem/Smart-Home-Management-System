package Model;

import java.util.ArrayList;

public class Room {
    private  String name;
    private int id;
    private String floor;
    private ArrayList<Device> devices;
    public Room(){
        devices = new ArrayList<>();
    }
    public Room (int id,String name,String floor){
        this.name = name;
        this.id = id;
        this.floor = floor;
        this.devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    public String getFloor() {
        return floor;
    }

    public void addDevice(Device device){
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
                name +"',id=" + id+"',floor ="+floor+ "',devices=" +
                 devices.size()+ "}";
    }


}
