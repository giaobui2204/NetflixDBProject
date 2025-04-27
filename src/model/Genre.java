package model;

import java.sql.Timestamp;

public class Genre {
    private int genre_id;
    private String name;
    private String description;

    public Genre(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Genre(int genre_id, String name, String description){
        this.genre_id = genre_id;
        this.name = name;
        this.description = description;
    }

    public int getGenre_id() {  return genre_id; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setGenre_id(int genre_id) { this.genre_id = genre_id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }

    public Object getGenreIdByName() {
        throw new UnsupportedOperationException("Unimplemented method 'getGenreIdByName'");
    }
}
