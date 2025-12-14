public class DeviceDAO {
    private Connection conn;

    public DeviceDAO(Connection conn) {
        this.conn = conn;
    }

    // Update device ON/OFF
    public boolean updateDeviceStatus(int deviceId, boolean newStatus) {
        try {
            String sql = "UPDATE Device SET status=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setBoolean(1, newStatus);
            stmt.setInt(2, deviceId);

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error (updateDeviceStatus): " + e.getMessage());
            return false;
        }
    }

    // Insert new device
    public boolean insertDevice(Device d) {
        try {
            String sql = "INSERT INTO Device(name, status, powerConsumption, roomId) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, d.getName());
            stmt.setBoolean(2, d.isStatus());
            stmt.setDouble(3, d.getPowerConsumption());
            stmt.setInt(4, d.getRoomId());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error (insertDevice): " + e.getMessage());
            return false;
        }
    }

    // Get all devices
    public List<Device> getAllDevices() {
        List<Device> devices = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Device";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Device d = new Device(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("status"),
                    rs.getDouble("powerConsumption"),
                    rs.getInt("roomId")
                );
                devices.add(d);
            }

        } catch (Exception e) {
            System.out.println("Error (getAllDevices): " + e.getMessage());
        }

        return devices;
    }
}
