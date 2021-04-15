package com.example.jokes.DevLife;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JokeInterface {
    @GET("/random?json=true")
    Call<Joke> getRandomJoke();

    @GET("/{id}?json=true")
    Call<Joke> getPost(
            @Path("id") String id
    );

}
