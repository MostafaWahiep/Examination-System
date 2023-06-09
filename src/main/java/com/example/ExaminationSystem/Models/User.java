package com.example.ExaminationSystem.Models;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verify_login(User user){
        if(user.username.equals(this.username) && this.password.equals(user.password))
            return true;
        return false;
    }
}
