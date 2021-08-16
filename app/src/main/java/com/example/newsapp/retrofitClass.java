package com.example.newsapp;

import com.example.newsapp.ModelPackage.apiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofitClass {

    private static Retrofit retrofit;
    private static final String BASEURL="https://newsapi.org/v2/";

    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
