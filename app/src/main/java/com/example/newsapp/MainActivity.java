package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.newsapp.ModelPackage.apiInterface;
import com.example.newsapp.ModelPackage.newsModelClass;
import com.example.newsapp.ModelPackage.newsModelClassContainer;
import com.example.newsapp.adaptorPckage.newsadaptor;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String api  ="62f19be3b9174737ab8ad1dea3c3f0b6";
    ArrayList<newsModelClass> modelClassArrayList ;
    Adapter adapter;
    String country ="in";
    private RecyclerView recyclerView;
    apiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = retrofitClass.getRetrofit().create(apiInterface.class);
        apiInterface.getnews().enqueue(new Callback<newsModelClassContainer>() {
            @Override
            public void onResponse(Call<newsModelClassContainer> call, Response<newsModelClassContainer> response) {
                newsModelClassContainer allnews = response.body();
                 List<newsModelClass> postLis = allnews.getArticles();
                 newsadaptor adaptorPost = new newsadaptor(MainActivity.this ,postLis );
                 recyclerView.setAdapter(adaptorPost);
            }

            @Override
            public void onFailure(Call<newsModelClassContainer> call, Throwable t) {

            }
        });


    }
}