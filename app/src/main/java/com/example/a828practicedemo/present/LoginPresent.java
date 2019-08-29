package com.example.a828practicedemo.present;

import com.example.a828practicedemo.model.LoginModel;
import com.example.a828practicedemo.view.LoginView;

public interface LoginPresent {
    void attachView(LoginView loginView);
    void login(LoginModel loginModel);
}
