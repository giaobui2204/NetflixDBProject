import dao.UserDAO;
import model.User;
import java.util.List;
import dao.MovieDAO;
import model.Movie;

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

        MovieDAO movieDAO = new MovieDAO();
        movieDAO.createTable();
        movieDAO.insertSampleData();
        for (Movie m: movieDAO.getAllMovies()){
            System.out.printf("%s (%d) - Rating: %.1f, Duration: %d min%n", m.getTitle(), m.getRelease_year(), m.getRating(), m.getDuration());
        }
    }
}
