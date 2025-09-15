package com.example.models.to;

import java.util.Date;
import java.util.Objects;

// src/main/java/com/example/model/User.java (Classic version without Lombok)

public class User {
    private long id;
    private String name;
    private String family;
    private String userName;
    private String passWord;
    private String email;
    private Date registrationDate;

    // Default constructor
    public User() {
    }

    // All-args constructor
    public User(long id, String name, String family, String userName, String passWord, String email, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(family, user.family) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(passWord, user.passWord) &&
                Objects.equals(email, user.email) &&
                Objects.equals(registrationDate, user.registrationDate);
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, name, family, userName, passWord, email, registrationDate);
    }
}