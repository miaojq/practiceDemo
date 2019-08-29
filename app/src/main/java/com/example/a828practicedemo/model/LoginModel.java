package com.example.a828practicedemo.model;

public class LoginModel {
    private String username;
    private String password;

    public LoginModel(String username, String passname) {
        this.username=username;
        this.password=passname;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
