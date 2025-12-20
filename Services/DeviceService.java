package Services;
import Database.DAO.DeviceDAO;
import Model.Device;
import java.util.List;

public class DeviceService {
    private final DeviceDAO deviceDAO;
    public DeviceService(){
        this.deviceDAO = new DeviceDAO();
    }
    public List<Device> getAllDevices(){
        return deviceDAO.getAllDevices();
    }
    public boolean addDevice(Device device){
        if(device== null){
            return false;
        }
        return deviceDAO.insertDevice(device);
    }
    public boolean turnOnDevice(int deviceId){
        Device device = deviceDAO.getDeviceById(deviceId);
        if (device == null || device.isOn()) return false;
        return deviceDAO.updateDeviceStatus(deviceId,true);
    }
    public boolean turnOffDevice(int deviceId){
        Device device =deviceDAO.getDeviceById(deviceId);
        if(device == null || ! device.isOn()) {
            return false;
        }
        return deviceDAO.updateDeviceStatus(deviceId,false);
        }
        public boolean toggleDevice(int deviceId){
        Device device = deviceDAO.getDeviceById(deviceId);
        if(device == null){
            return false;
        }
        return deviceDAO.updateDeviceStatus(deviceId,!device.isOn());
        }
        public String getDeviceStatus(int deviceId){
        Device device = deviceDAO.getDeviceById(deviceId);
        if(device == null){
            return "Device not found";
        }
        return device.getStatus();
        }
        public boolean clearAllDevices(){
        return deviceDAO.clearDevicesTable();
        }
    }

