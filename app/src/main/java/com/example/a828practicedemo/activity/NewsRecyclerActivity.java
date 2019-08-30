package com.example.a828practicedemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a828practicedemo.R;
import com.example.a828practicedemo.adapter.NewsRecyclerAdapter;
import com.example.a828practicedemo.bean.ContentBean;

import java.util.ArrayList;
import java.util.List;

public class NewsRecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContentBean contentBean;
    private List<ContentBean> contentBeans;
    private List<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_recycler);
        initData();
        recyclerView=(RecyclerView)findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewsRecyclerAdapter(this,strings,contentBeans));

    }
//添加数据
    private void initData(){
        contentBean=new ContentBean();
        contentBeans=new ArrayList<>();
        strings=new ArrayList<>();
        for (int i = 0; i <10; i++) {

            strings.add("新闻"+i);

        }
        for (int i = 0; i <30 ; i++) {

            contentBean.setSubstance("内容"+i);
            contentBean.setImgNews(R.drawable.ic_launcher_background);

            contentBeans.add(contentBean);

        }


    }
}
