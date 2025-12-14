public class LogDAO {
    private Connection conn;

    public LogDAO(Connection conn) {
        this.conn = conn;
    }

    // Write log entry
    public boolean writeLog(int userId, int deviceId, String action) {
        try {
            String sql = "INSERT INTO Log(userId, deviceId, action, timestamp) VALUES (?, ?, ?, GETDATE())";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, userId);
            stmt.setInt(2, deviceId);
            stmt.setString(3, action);

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error (writeLog): " + e.getMessage());
            return false;
        }
    }
}
