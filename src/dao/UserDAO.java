package dao;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class UserDAO {
    public void createTable(){
        String sql = """
            CREATE TABLE IF NOT EXISTS user (
                user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT UNIQUE NOT NULL,
                email TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL,
                subscription_id INTEGER,
                date_joined TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                FOREIGN KEY (subscription_id) REFERENCES Subscription(subscription_id) ON DELETE SET NULL
            );
            """;
        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    public void insertSampleData(){
        String sql = "INSERT OR IGNORE INTO User(username, email, password, subscription_id) VALUES(?, ?, ?, ?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "john_doe");
            pstmt.setString(2, "john@example.com");
            pstmt.setString(3, "pass123");
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();

            pstmt.setString(1, "jane_smith");
            pstmt.setString(2, "jane@example.com");
            pstmt.setString(3, "secret456");
            pstmt.setInt(4, 2);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getInt("subscription_id"),
                    rs.getTimestamp("date_joined")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}