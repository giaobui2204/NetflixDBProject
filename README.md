# NetflixDBProject 🎬

This project is a simplified backend model of a **Netflix-style movie streaming system** implemented in Java using **SQLite** as the database. The design is based on relational database modeling and follows **Version 2** of the sample implementation pattern — using **JDBC** with a **DAO (Data Access Object)** architecture for clean separation of concerns.

## 📌 Features

- Create tables for:
  - Users
  - Subscriptions
  - Movies
  - Genres
  - Watch History
- Insert sample data into each table
- Retrieve and display all users, movies, and subscription plans
- Automatically creates the database from scratch if it doesn’t exist

## 🛠 Technologies Used

- Java (JDK 17+)
- SQLite (via `sqlite-jdbc` driver)
- JDBC (Java Database Connectivity)
- DAO Pattern 

## 📂 Folder Structure

NetflixDBProject/ ├── lib/ │ └── sqlite-jdbc-<version>.jar ├── src/ │ ├── Main.java │ ├── dao/ │ │ ├── DBConnection.java │ │ ├── SubscriptionDAO.java │ │ ├── UserDAO.java │ │ ├── MovieDAO.java │ │ ├── GenreDAO.java │ │ └── WatchHistoryDAO.java │ └── model/ │ ├── Subscription.java │ ├── User.java │ ├── Movie.java │ ├── Genre.java │ └── WatchHistory.java


## 🧪 How to Run

### 1. Compile

```bash
find src -name "*.java" | xargs javac -cp "lib/sqlite-jdbc-3.49.1.0.jar" -d bin

### 2. Run

```bash 
java -cp "bin:lib/sqlite-jdbc-3.49.1.0.jar" Main
