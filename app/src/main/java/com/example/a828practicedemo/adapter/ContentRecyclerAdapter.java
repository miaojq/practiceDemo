package com.example.a828practicedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a828practicedemo.R;
import com.example.a828practicedemo.bean.ContentBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ContentRecyclerAdapter extends RecyclerView.Adapter<ContentRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<ContentBean> contentBeans;
    public int position;

    public ContentRecyclerAdapter(Context context,List<ContentBean> contentBeans,int position){
        this.context=context;
        this.contentBeans=contentBeans;
        this.position=position;
    }
    public void setPosition(int position){
        this.position=position;
    }


    @NonNull
    @Override
    public ContentRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content,null);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imgView.setImageResource(contentBeans.get(position).getImgNews());
        holder.txtView.setText(contentBeans.get(position).getSubstance());

    }


    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgView;
        TextView txtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.img_news);
            txtView=itemView.findViewById(R.id.txt_news);
        }
    }
}
