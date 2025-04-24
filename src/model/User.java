package model;

import java.sql.Timestamp;

public class User {
    private int userId;               
    private String username;         
    private String email;           
    private String password;         
    private int subscriptionId;     
    private Timestamp dateJoined;    

    // Constructor for inserts
    public User(String username, String email, String password, int subscriptionId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscriptionId = subscriptionId;
    }

    // Constructor for fetch/display
    public User(int userId, String username, String email, String password, int subscriptionId, Timestamp dateJoined) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscriptionId = subscriptionId;
        this.dateJoined = dateJoined;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public int getSubscriptionId() { return subscriptionId; }
    public Timestamp getDateJoined() { return dateJoined; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setSubscriptionId(int subscriptionId) { this.subscriptionId = subscriptionId; }
    public void setDateJoined(Timestamp dateJoined) { this.dateJoined = dateJoined; }
}
