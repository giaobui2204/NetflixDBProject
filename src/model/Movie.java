package model;

public class Movie {
    private int movie_id;
    private String title;
    private String description;
    private int release_year;
    private int genre_id;
    private double rating;
    private int duration;

    public Movie(String title, String description, int release_year, int genre_id, double rating, int duration){
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.genre_id = genre_id;
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(int movie_id, String title, String description, int release_year, int genre_id, double rating, int duration){
        this.movie_id = movie_id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.genre_id = genre_id;
        this.rating = rating;
        this.duration = duration;
    }

    //Getters
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getRelease_year() {
        return release_year;
    }
    public int getGenre_id() {
        return genre_id;
    }
    public double getRating() {
        return rating;
    }
    public int getDuration() {
        return duration;
    }

    //Setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}