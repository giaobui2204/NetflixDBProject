package dao;

import model.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    public void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Genre (
                genre_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT UNIQUE NOT NULL,
                description TEXT
            );
        """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSampleData() {
        String sql = "INSERT OR IGNORE INTO Genre(name, description) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Sci-Fi");
            pstmt.setString(2, "Science fiction movies with futuristic elements.");
            pstmt.executeUpdate();

            pstmt.setString(1, "Thriller");
            pstmt.setString(2, "Suspense and mystery-driven films.");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM Genre";

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                genres.add(new Genre(
                    rs.getInt("genre_id"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    public Integer getGenreIdByName(String name) {
        String sql = "SELECT genre_id FROM Genre WHERE name = ?";
        try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("genre_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    
}
