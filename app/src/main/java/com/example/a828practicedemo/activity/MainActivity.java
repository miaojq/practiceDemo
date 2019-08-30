package com.example.a828practicedemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.example.a828practicedemo.R;
import com.example.a828practicedemo.model.LoginModel;
import com.example.a828practicedemo.present.LoginPresent;
import com.example.a828practicedemo.present.LoginPresentImpl;
import com.example.a828practicedemo.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView, CompoundButton.OnCheckedChangeListener{
    private EditText edt_username;
    private EditText edt_passname;
    private Button btn_login;
    private Button btn_register;
    private CheckBox cbx_rememberPassword;
    private LoginPresent loginPresent;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("config",0);

        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_passname = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);

//        读取config文件中的name和pwd放到对应的editText中
        String name=sp.getString("name","");
        String pwd=sp.getString("pwd","");
        edt_username.setText(name);
        edt_passname.setText(pwd);

        cbx_rememberPassword=(CheckBox)findViewById(R.id.cbx_rememberPassword);
//      设置一个改变的监听
        cbx_rememberPassword.setOnCheckedChangeListener(this);

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
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("RegisterAction");
                intent.addCategory("RegisterCategory");
                startActivity(intent);

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

    @Override
    public void saveUserInfo(String username, String password) {
        //初始化sp

        sp=getSharedPreferences("config",0);
        SharedPreferences.Editor editor=sp.edit();
        String name=sp.getString("name","");
        String pwd=sp.getString("pwd","");
//        把editort提交
        editor.commit();

        editor.putString("name",username);
        editor.putString("pwd",password);
        edt_username.setText(name);
        edt_passname.setText(pwd);
}


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked())
        {

        }
    }
}
