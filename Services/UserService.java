package Services;


import Database.DAO.UserDAO;
import Model.User;

public class UserService {
    private final UserDAO userDAO;
    public UserService(){
        this.userDAO = new UserDAO();
    }
    public User getUserById(int id){
        return userDAO.getUserById(id);
    }
    public User getUserByUsername(String username){
        return userDAO.getUserByUserName(username);
    }
    public boolean registerUser(User user) {
        if (user == null)
            return false;
        if (userDAO.getUserByUserName(user.getUsername()) != null)
            return false;
        return userDAO.insertUser(user);
    }
    public boolean login(String username, String password){
       if (username == null || password == null) return false;
       if (username.trim().isEmpty() || password.trim().isEmpty()) return false;
       User user = userDAO.getUserByUserName(username);
       if (user== null)return false;
       if (user.getPassword()== null)return false;
       return user.getPassword().equals(password);
    }
    public User ensureAdminExists(){
        User admin = userDAO.getUserByUserName("admin");
        if (admin == null){
            admin = new User(
                    0,
                    "admin",
                    "1234",
                    "admin@test.com",
                    "0100000000",
                    "default",
                    "EN",
                    true,
                    "dark",
                    false,
                    null,
                    "ADMIN",
                    0,
                    "",
                    false
            );
            userDAO.insertUser(admin);
            System.out.println("Admin user created");
        }
        return admin;
    }

}
