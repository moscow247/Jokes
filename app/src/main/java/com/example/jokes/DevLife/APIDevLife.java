package com.example.jokes.DevLife;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIDevLife {
    public static Retrofit getClient(){
        OkHttpClient client = new OkHttpClient.Builder().build();

        return new Retrofit.Builder()
                .baseUrl("https://developerslife.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
