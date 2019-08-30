package com.example.a828practicedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a828practicedemo.R;
import com.example.a828practicedemo.bean.ContentBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;



public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<String> strings;
    private List<ContentBean> contentBeans;
    private ViewHolder viewHolder;
    private ContentRecyclerAdapter contentRecyclerAdapter;

    public NewsRecyclerAdapter(Context context,List<String>strings,List<ContentBean>contentBeans){
        this.context=context;
        this.strings=strings;
        this.contentBeans=contentBeans;
    }
    @NonNull
    @Override
    public NewsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerAdapter.ViewHolder holder, int position) {
        holder.textView.setText(strings.get(position));

        contentRecyclerAdapter=new ContentRecyclerAdapter(context,contentBeans,position);
        holder.contentRecyclerAdapter=new ContentRecyclerAdapter(context,holder.contentBeans,position);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(contentRecyclerAdapter);

    }
    @Override
    public int getItemCount() {
        return 10;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private RecyclerView recyclerView;
        private ContentRecyclerAdapter contentRecyclerAdapter;
        private List<ContentBean> contentBeans=new ArrayList<>();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.news_tittle);
            recyclerView=itemView.findViewById(R.id.content_news);

        }
    }
}
