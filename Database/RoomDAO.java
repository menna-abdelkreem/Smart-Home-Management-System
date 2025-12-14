public class RoomDAO {
    private Connection conn;

    public RoomDAO(Connection conn) {
        this.conn = conn;
    }

    // Get devices inside a room
    public List<Device> getDevicesInRoom(int roomId) {
        List<Device> devices = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Device WHERE roomId=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, roomId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                devices.add(new Device(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("status"),
                    rs.getDouble("powerConsumption"),
                    rs.getInt("roomId")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error (getDevicesInRoom): " + e.getMessage());
        }

        return devices;
    }

    // Move device to room
    public boolean addDeviceToRoom(int roomId, int deviceId) {
        try {
            String sql = "UPDATE Device SET roomId=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, roomId);
            stmt.setInt(2, deviceId);
            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            System.out.println("Error (addDeviceToRoom): " + e.getMessage());
            return false;
        }
    }
}
