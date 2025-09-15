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

    }
}
