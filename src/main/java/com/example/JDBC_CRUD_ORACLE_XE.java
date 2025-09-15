package com.example;

import com.example.models.dao.UserDAO;
import com.example.models.to.User;

import java.sql.*;
import java.util.Scanner;

public class JDBC_CRUD_ORACLE_XE {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "test";
        String password = "test";

        // داده نمونه
        long user_id = 0;
        String user_name = null;
        String user_family = null;
        String user_username = null;
        String user_password = null;
        String user_email = null;
        Timestamp user_registrationDate = new Timestamp(System.currentTimeMillis());
//        Timestamp user_lastLoginDate = new Timestamp(System.currentTimeMillis());

        // دریافت ورودی از کاربر
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter id:");
//        user_id = Long.parseLong(scanner.nextLine());
        System.out.println("Enter name:");
        user_name = scanner.nextLine();
        System.out.println("Enter family:");
        user_family = scanner.nextLine();
        System.out.println("Enter username:");
        user_username = scanner.nextLine();
        System.out.println("Enter password:");
        user_password = scanner.nextLine();
        System.out.println("Enter email:");
        user_email = scanner.nextLine();

        User user = new User(user_id,user_name,user_family,user_username,user_password,user_email,user_registrationDate);

        UserDAO userDAO = new UserDAO();
        try {
            userDAO.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        // 1) چک وجود رکورد با USERNAME یا EMAIL
//        String checkSql = "SELECT ID, USER_NAME, EMAIL, REGISTRATION_DATE "
//                + "FROM USERS WHERE USER_NAME = ? OR EMAIL = ?";
//
//        // 2) INSERT در صورت نبود رکورد
//        String insertSql = "INSERT INTO USERS (ID, NAME,FAMILY,USER_NAME, PASS_WORD, EMAIL, REGISTRATION_DATE) "
//                + "VALUES (seq_users.nextval, ?, ?, ?, ?, ?,?)";
//
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             // برای درج
//             PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {
//
//            // رکورد وجود ندارد، اقدام به INSERT
//            // Bind parameters for INSERT
//            insertStmt.setString(1, user_name);
//            insertStmt.setString(2, user_family);
//            insertStmt.setString(3, user_username);
//            insertStmt.setString(4, user_password);
//            insertStmt.setString(5, user_email);
//            insertStmt.setTimestamp(6, user_registrationDate);
//            insertStmt.setTimestamp(5, user_lastLoginDate);
//
//            int rows = insertStmt.executeUpdate();
//            System.out.println("Inserted rows: " + rows);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}