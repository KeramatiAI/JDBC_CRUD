package com.example.models.dao;

// src/main/java/com/example/dao/UserDAO.java (Shared for both versions, with clean code practices)
// Note: This uses try-with-resources for auto-closing resources, which is clean and recommended in modern Java.
// If you need explicit close methods, they can be added, but try-with-resources is cleaner.
// Assumes the database table 'users' exists with columns: id (NUMBER), name (VARCHAR2), family (VARCHAR2), user_name (VARCHAR2), pass_word (VARCHAR2), email (VARCHAR2), registration_date (DATE)
// Create table script: CREATE TABLE users (id NUMBER PRIMARY KEY, name VARCHAR2(50), family VARCHAR2(50), user_name VARCHAR2(50), pass_word VARCHAR2(50), email VARCHAR2(100), registration_date DATE);

import com.example.models.to.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";  // Adjust if needed
    private static final String DB_USER = "test";  // Replace with your Oracle username
    private static final String DB_PASSWORD = "test";  // Replace with your Oracle password

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver not found", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Insert method
    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO USERS (ID, NAME,FAMILY,USER_NAME, PASS_WORD, EMAIL, REGISTRATION_DATE) "
                + "VALUES (seq_users.nextval, ?, ?, ?, ?, ?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getFamily());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getPassWord());
            pstmt.setString(5, user.getEmail());
            pstmt.setDate(6, new java.sql.Date(user.getRegistrationDate().getTime()));
            pstmt.executeUpdate();
        }
    }

    // Update method
    public void update(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, family = ?, user_name = ?, pass_word = ?, email = ?, registration_date = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getFamily());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getPassWord());
            pstmt.setString(5, user.getEmail());
            pstmt.setDate(6, new java.sql.Date(user.getRegistrationDate().getTime()));
            pstmt.setLong(7, user.getId());
            pstmt.executeUpdate();
        }
    }

    // Delete method
    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        }
    }

    // Read (find by id)
    public User findById(long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
                return null;
            }
        }
    }

    // Read all
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }
            return users;
        }
    }

    // Helper method to map ResultSet to User
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setFamily(rs.getString("family"));
        user.setUserName(rs.getString("user_name"));
        user.setPassWord(rs.getString("pass_word"));
        user.setEmail(rs.getString("email"));
        user.setRegistrationDate(rs.getDate("registration_date"));
        return user;
    }
}
