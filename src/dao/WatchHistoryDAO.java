package dao; 

import model.WatchHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WatchHistoryDAO {
    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Watch_History (
                user_id INTEGER,
                movie_id INTEGER,
                watch_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                PRIMARY KEY (user_id, movie_id, watch_date),
                FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE,
                FOREIGN KEY (movie_id) REFERENCES Movie(movie_id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSampleData() {
        String sql = "INSERT INTO Watch_History(user_id, movie_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 1);  
            pstmt.setInt(2, 1);  
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);  
            pstmt.setInt(2, 2);  
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<WatchHistory> getAllWatchHistory() {
        List<WatchHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM Watch_History";

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new WatchHistory(
                    rs.getInt("user_id"),
                    rs.getInt("movie_id"),
                    rs.getTimestamp("watch_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}