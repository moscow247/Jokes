package com.example.jokes.Chuck;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChuckJokeInterface {
    @GET("/jokes/random")
    Call<ChuckJoke> getRandomJoke();
}
