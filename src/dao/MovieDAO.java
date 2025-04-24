package dao;

import model.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MovieDAO{
    public void createTable(){
        String sql = """
        CREATE TABLE IF NOT EXISTS Movie (
            movie_id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL, 
            description TEXT,
            release_year INTEGER NOT NULL,
            genre_id INTEGER, 
            rating REAL CHECK (rating BETWEEN 0 AND 10),
            duration INTEGER NOT NULL CHECK (duration > 0),
            FOREIGN KEY (genre_id) REFERENCES Genre(genre_id) ON DELETE SET NULL);
        """;

        try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()){
            stmt.execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertSampleData(){
        String sql = "INSERT OR IGNORE INTO Movie(title, description, release_year, genre_id, rating, duration) VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Interstellar");
            pstmt.setString(2, "Epic science fiction space exploration.");
            pstmt.setInt(3, 2014);
            pstmt.setInt(4, 1);
            pstmt.setDouble(5, 8.6);
            pstmt.setInt(6, 169);
            pstmt.executeUpdate();

            pstmt.setString(1, "Parasite");
            pstmt.setString(2, "South Korean dark comedy thriller.");
            pstmt.setInt(3, 2019);
            pstmt.setInt(4, 2);
            pstmt.setDouble(5, 8.6);
            pstmt.setInt(6, 132);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    

}