package com.example.a828practicedemo.view;

public interface LoginView {
    void showToast(String msg);
    void successLogin(String msg);
    void failLogin(String msg);
    void skip();
    void saveUserInfo(String username,String password);

}
