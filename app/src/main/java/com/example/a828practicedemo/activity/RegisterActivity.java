package com.example.a828practicedemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a828practicedemo.R;

public class RegisterActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        imageView=(ImageView)findViewById(R.id.img_fromInternet);

        Glide.with(this).load("https://himg2.huanqiucdn.cn/attachment2010/2019/0829/14/01/20190829020139271.jpg").into(imageView);
    }
}
