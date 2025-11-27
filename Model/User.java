package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

   private int id;
   private String username;
   private String password;
   private String email;
   private String phone;
   private String preferredMode;
   private String language;
   private boolean notificationsEnable;
   private String theme;
   private  boolean twoFactorEnabled;
   private LocalDateTime LastLogin;
   private String role;
   private final List<String> allowedRooms;
   private final List<String> allowedDevices;
   private double totalUsageHours;
   private String lastUsedDevice;
   private boolean energySavingMode;

    public User(int id, String username, String password, String email, String phone, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.language = "EN";
        this.theme = "light";
        this.preferredMode = "Home";
        this.notificationsEnable = true;
        this.twoFactorEnabled = false;
        this.LastLogin = LocalDateTime.now();
        this.allowedRooms = new ArrayList<>();
        this.allowedDevices = new ArrayList<>();
        this.totalUsageHours = 0.0;
        this.lastUsedDevice = "None";
        this.energySavingMode = false;
    }
        public int getId() {
            return id;
        }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPreferredMode() {
        return preferredMode;
    }
    public void setPreferredMode(String preferredMode) {
        this.preferredMode = preferredMode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isNotificationsEnable() {
        return notificationsEnable;
    }

    public void setNotificationsEnable(boolean notificationsEnable) {
        this.notificationsEnable = notificationsEnable;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public LocalDateTime getLastLogin() {
        return LastLogin;
    }

    public void updateLastLogin(){
       this.LastLogin = LocalDateTime.now();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAllowedRooms() {
        return allowedRooms;
    }

    public void addAllowedRooms(String roomName) {
        this.allowedRooms.add(roomName);
        if (! allowedDevices.contains(roomName)){
            allowedDevices.add(roomName);
        }
    }
    public void removeAllowedRoom(String roomName){
        allowedRooms.remove(roomName);
    }

    public List<String> getAllowedDevices() {
        return allowedDevices;
    }

    public void addAllowedDevices(String device) {
        this.allowedDevices.add(device);
        if (!allowedDevices.contains(device)) {
            allowedDevices.add(device);
        }
    }
    public void removeAllowedDevices(String device){
        allowedDevices.remove(device);
    }

    public double getTotalUsageHours() {
        return totalUsageHours;
    }

    public void addUsageHours(double hours) {
        this.totalUsageHours += hours;
    }

    public String getLastUsedDevice() {
        return lastUsedDevice;
    }

    public void setLastUsedDevice(String lastUsedDevice) {
        this.lastUsedDevice = lastUsedDevice;
    }

    public boolean isEnergySavingMode() {
        return energySavingMode;
    }

    public void enableEnergySavingMode() {
        this.energySavingMode = true;
    }
    public boolean canAccessDevice(String deviceName){
        return role.equals("Admin") || allowedDevices.contains(deviceName);
    }
    public boolean canAccessRoom(String roomName){
        return role.equals("Admin") || allowedRooms.contains(roomName);
    }
    public void updateProfile(String newEmail,String newPhone,String newTheme){
        this.email = newEmail;
        this.phone = newPhone;
        this.theme = newTheme;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", preferredMode='" + preferredMode + '\'' +
                ", language='" + language + '\'' +
                ", notificationsEnable=" + notificationsEnable +
                ", theme='" + theme + '\'' +
                ", twoFactorEnabled=" + twoFactorEnabled +
                ", LastLogin=" + LastLogin +
                ", role='" + role + '\'' +
                ", allowedRooms=" + allowedRooms +
                ", allowedDevices=" + allowedDevices +
                ", totalUsageHours=" + totalUsageHours +
                ", lastUsedDevice='" + lastUsedDevice + '\'' +
                ", energySavingMode=" + energySavingMode +
                '}';
    }

}
