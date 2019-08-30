package com.example.a828practicedemo.present;

import com.example.a828practicedemo.model.LoginModel;
import com.example.a828practicedemo.view.LoginView;

public class LoginPresentImpl implements LoginPresent {
    private LoginView loginView;
    @Override
    public void attachView(LoginView loginView) {
        this.loginView=loginView;
    }


    @Override
    public void login(LoginModel loginModel) {
        if(loginModel.getUsername().isEmpty()||loginModel.getUsername()==""){
            loginView.failLogin("账号不能为空");
        }
        else if (loginModel.getPassword().isEmpty()||loginModel.getPassword()==""){
            loginView.failLogin("密码不能为空");
        }
        else if (!loginModel.getUsername().equals("123456")){
            loginView.failLogin("账号错误");
        }
        else if(!loginModel.getPassword().equals("123")){
            loginView.failLogin("密码错误");

        }else {
            loginView.successLogin("登陆成功");
            loginView.skip();
        }

    }
}
