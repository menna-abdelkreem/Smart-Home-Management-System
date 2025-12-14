public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    // Authenticate user
    public boolean authenticateUser(String username, String password) {
        try {
            String sql = "SELECT * FROM Users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Error (authenticateUser): " + e.getMessage());
            return false;
        }
    }

    // Insert new user
    public boolean insertUser(User user) {
        try {
            String sql = "INSERT INTO Users(username, password, email, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Error (insertUser): " + e.getMessage());
            return false;
        }
    }
}
