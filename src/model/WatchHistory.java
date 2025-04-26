package model;

import java.sql.Timestamp;

public class WatchHistory {
    private int user_id;
    private int movie_id;
    private Timestamp watch_date;

    public WatchHistory(int user_id, int movie_id, Timestamp watch_date){
        this.user_id = user_id;
        this.movie_id = movie_id;
        this.watch_date = watch_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public Timestamp getWatch_date() {
        return watch_date;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setWatch_date(Timestamp watch_date) {
        this.watch_date = watch_date;
    }
}