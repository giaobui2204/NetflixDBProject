package model;

import java.security.Timestamp;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private int subcription_id;
    private Timestamp date_joined;
    

    //constructor for user insert
    public User(String username, String email, String password, int subscription_id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subcription_id = subscription_id;
    }

    //constructor for all fields (fetch/display)
    public User(String username, String email, String password, int subscription_id, Timestamp date_joined){
        this.username = username;
        this.email = email;
        this.password = password;
        this.subcription_id = subscription_id;
        this.date_joined = date_joined;
    }


    //getters
    public int getUser_id() {
        return user_id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getSubcription_id() {
        return subcription_id;
    }
    public Timestamp getDate_joined() {
        return date_joined;
    }


    //setters
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setSubcription_id(int subscription_id) {
        this.subcription_id = subscription_id;
    }
    public void setDate_joined(Timestamp date_joined) {
        this.date_joined = date_joined;
    }
}