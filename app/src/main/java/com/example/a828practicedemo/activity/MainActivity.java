package com.example.a828practicedemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a828practicedemo.R;
import com.example.a828practicedemo.model.LoginModel;
import com.example.a828practicedemo.present.LoginPresent;
import com.example.a828practicedemo.present.LoginPresentImpl;
import com.example.a828practicedemo.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {
    private EditText edt_username;
    private EditText edt_passname;
    private Button btn_login;
    private Button btn_register;
    private LoginPresent loginPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_passname = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

        loginPresent=new LoginPresentImpl();
        loginPresent.attachView(this);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= String.valueOf(edt_username.getText());
                String passname= String.valueOf(edt_passname.getText());

                LoginModel loginModel=new LoginModel(username,passname);
                loginPresent.login(loginModel);

            }
        });

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void successLogin(String msg) {
        showToast(msg);
    }

    @Override
    public void failLogin(String msg) {
        showToast(msg);

    }
    @Override
    public void skip() {
        Intent intent=new Intent();
        intent.setAction("NewsAction");
        intent.addCategory("NewsCategory");
        startActivity(intent);
    }
}
