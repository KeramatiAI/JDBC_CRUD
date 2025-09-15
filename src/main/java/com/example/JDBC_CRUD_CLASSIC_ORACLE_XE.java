package com.example;

import com.example.models.dao.UserDAO;
import com.example.models.to.User;

import java.util.Date;

public class JDBC_CRUD_CLASSIC_ORACLE_XE {
    public static void main(String[] args) throws Exception{

        long id = 44;
        String name = "David";
        String family = "Keramati";
        String userName = "davidkeramati";
        String passWord = "hjhtjhtjhtjthj";
        String email = "davoud.keramati@gmail.com";
        Date registrationDate = new Date();

        User user1 = new User(id,name,family,userName,passWord,email,registrationDate);

        UserDAO userDAO = new UserDAO();
        userDAO.insert(user1);
    }
}
