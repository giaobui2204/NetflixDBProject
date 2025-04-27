import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.DBConnection;
import dao.GenreDAO;
import dao.MovieDAO;
import model.Genre;
import model.Movie;
import dao.WatchHistoryDAO;
import model.WatchHistory;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        GenreDAO genreDAO = new GenreDAO();
        MovieDAO movieDAO = new MovieDAO();
        WatchHistoryDAO historyDAO = new WatchHistoryDAO();
        
        userDAO.createTable();
        genreDAO.createTable();
        movieDAO.createTable();
        historyDAO.createTable();

        userDAO.insertSampleData();
        genreDAO.insertSampleData();
        movieDAO.insertSampleData();
        historyDAO.insertSampleData();
        

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n===== NetflixDB Menu =====");
            System.out.println("1. View All Users");
            System.out.println("2. View All Genres");
            System.out.println("3. View All Movies");
            System.out.println("4. View All Watch History");
            System.out.println("5. Add new User");
            System.out.println("6. Add new Movie");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    List<User> users = userDAO.getAllUsers();
                    for (User u : users) {
                        System.out.printf("ID: %d | Username: %s | Email: %s | SubID: %d | Joined: %s%n",
                            u.getUserId(), u.getUsername(), u.getEmail(), u.getSubscriptionId(), u.getDateJoined());
                    }
                    break;
                case 2:
                    List<Genre> genres = genreDAO.getAllGenres();
                    for (Genre g : genres) {
                        System.out.printf("Genre ID: %d | Name: %s | Description: %s%n",
                            g.getGenre_id(), g.getName(), g.getDescription());
                    }
                    break;
                case 3:
                    List<Movie> movies = movieDAO.getAllMovies();
                    for (Movie m : movies) {
                        System.out.printf("Movie ID: %d | Title: %s | Year: %d | Genre ID: %d | Rating: %.1f | Duration: %d min%n",
                            m.getMovie_id(), m.getTitle(), m.getRelease_year(), m.getGenre_id(), m.getRating(), m.getDuration());
                    }
                    break;
                case 4:
                    List<WatchHistory> histories = WatchHistoryDAO.getAllWatchHistory();
                    for (WatchHistory h : histories) {
                        System.out.printf("User %d watched Movie %d on %s%n",
                            h.getUser_id(), h.getMovie_id(), h.getWatch_date());
                    }
                    break;
                case 5:
                    System.out.println("Enter username:");
                    String username = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    System.out.println("Enter subscription ID (integer):");
                    int subscriptionId = Integer.parseInt(scanner.nextLine());

                    try (Connection conn = DBConnection.connect();
                        PreparedStatement pstmt = conn.prepareStatement(
                            "INSERT INTO User(username, email, password, subscription_id) VALUES (?, ?, ?, ?)")) {
                        pstmt.setString(1, username);
                        pstmt.setString(2, email);
                        pstmt.setString(3, password);
                        pstmt.setInt(4, subscriptionId);
                        pstmt.executeUpdate();
                        System.out.println(" New user added successfully!");
                    } catch (SQLException e) {
                        System.out.println(" Failed to add user: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Enter movie title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter movie description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter release year (integer):");
                    int releaseYear = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter genre ID (integer):");
                    int genreId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter movie rating (0-10):");
                    double rating = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter movie duration (minutes):");
                    int duration = Integer.parseInt(scanner.nextLine());

                    try (Connection conn = DBConnection.connect();
                        PreparedStatement pstmt = conn.prepareStatement(
                            "INSERT INTO Movie(title, description, release_year, genre_id, rating, duration) VALUES (?, ?, ?, ?, ?, ?)")) {
                        pstmt.setString(1, title);
                        pstmt.setString(2, description);
                        pstmt.setInt(3, releaseYear);
                        pstmt.setInt(4, genreId);
                        pstmt.setDouble(5, rating);
                        pstmt.setInt(6, duration);
                        pstmt.executeUpdate();
                        System.out.println(" New movie added successfully!");
                    } catch (SQLException e) {
                        System.out.println(" Failed to add movie: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    break;
            }
        }
        
    }
}
