package com.example.newsapp.ModelPackage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiInterface {

//    @GET("top-headlines")
//    Call<List<newsModelClass>> getNews(
//            @Query("country") String country,
////            @Query("pageSize") int pagesize,
//            @Query("apiKey") String apiKey
//    );
//    Call<newsModelClassContainer> getCatagoryNews(
//            @Query("country") String country,
//            @Query("pageSize") int pagesize,
//            @Query("apiKey") String apiKey
//    );
    @GET("top-headlines?apiKey=62f19be3b9174737ab8ad1dea3c3f0b6&country=in")
            Call<newsModelClassContainer> getnews();
}
