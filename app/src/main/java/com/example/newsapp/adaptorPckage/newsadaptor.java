package com.example.newsapp.adaptorPckage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.ModelPackage.newsModelClass;
import com.example.newsapp.ModelPackage.newsModelClassContainer;
import com.example.newsapp.R;
import com.example.newsapp.webView;

import java.util.ArrayList;
import java.util.List;

public class newsadaptor extends RecyclerView.Adapter<newsadaptor.viewHolder> {
   Context context;
   List<newsModelClass> newsModelClassContainerArrayList;

    public newsadaptor(Context context, List<newsModelClass> newsModelClassContainerArrayList) {
        this.context = context;
        this.newsModelClassContainerArrayList = newsModelClassContainerArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyler_unit , null,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsadaptor.viewHolder holder, int position) {
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, webView.class);
//                intent.putExtra("url" , newsModelClassContainerArrayList.get(position).getUrl());
//                context.startActivity(intent);
//            }
//        });
        holder.mpublisher.setText(newsModelClassContainerArrayList.get(position).getAuthor());
        holder.mheader.setText(newsModelClassContainerArrayList.get(position).getTitle());
        holder.mcontent.setText(newsModelClassContainerArrayList.get(position).getContent());
        holder.mtime.setText(newsModelClassContainerArrayList.get(position).getPublishedAt());
        Glide.with(context).load(newsModelClassContainerArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return newsModelClassContainerArrayList.size() ;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView imageView;
        TextView mheader, mcontent, mpublisher, mtime;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.image_source);
            mheader = itemView.findViewById(R.id.header);
            mcontent= itemView.findViewById(R.id.text_content);
            mpublisher = itemView.findViewById(R.id.text_author);
            mtime =itemView.findViewById(R.id.text_time);
        }
    }
}
