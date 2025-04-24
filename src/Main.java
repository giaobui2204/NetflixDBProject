import dao.UserDAO;
import model.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        userDAO.createTable();
        userDAO.insertSampleData();

        List<User> users = userDAO.getAllUsers();
        for (User u : users) {
            System.out.printf("ID: %d | Username: %s | Email: %s | SubID: %d | Joined: %s%n",
                u.getUserId(), u.getUsername(), u.getEmail(), u.getSubscriptionId(), u.getDateJoined());
        }
    }
}
