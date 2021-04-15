package com.example.jokes.Chuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jokes.DevLife.APIDevLife;
import com.example.jokes.DevLife.DevLife;
import com.example.jokes.DevLife.Joke;
import com.example.jokes.DevLife.JokeInterface;
import com.example.jokes.DevLife.PreviousPost;
import com.example.jokes.R;
import com.example.jokes.databinding.ActivityChuckBinding;

import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chuck extends AppCompatActivity {
    ActivityChuckBinding binding;

    ChuckJokeInterface jokeInterface;
    private String logo = "https://assets.chucknorris.host/img/avatar/chuck-norris.png";

    protected boolean isOnline() {
        String cs = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(cs);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuck);
        binding = ActivityChuckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent MainActivity = new Intent(this, com.example.jokes.MainActivity.class);
        if(isOnline()) {
            ImageView ImageView = (ImageView) findViewById(R.id.imageView);

            Glide
                    .with(Chuck.this)
                    .load(logo)
                    .into(ImageView);

            binding.textView.setText("Chuck is cool");
            getSupportActionBar().hide();

            jokeInterface = ChuckAPI.getClient().create(ChuckJokeInterface.class);

            binding.btnNext.setOnClickListener(V -> {
                Call<ChuckJoke> call = jokeInterface.getRandomJoke();
                call.enqueue(new Callback<ChuckJoke>() {
                    @Override
                    public void onResponse(Call<ChuckJoke> call, Response<ChuckJoke> response) {
                        ChuckJoke randomJoke = response.body();
                        binding.textView.setText(randomJoke.getValue());

                        Glide
                                .with(Chuck.this)
                                .load(randomJoke.getIconUrl())
                                .into(ImageView);

                    }

                    @Override
                    public void onFailure(Call<ChuckJoke> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "sorry, something is wrong", Toast.LENGTH_LONG)
                                .show();
                        binding.textView.setText(R.string.notNetworkConnection);
                    }
                });
            });

        }else{
            binding.textView.setText(R.string.notNetworkConnection);
        }
            binding.back.setOnClickListener(V -> {
                startActivity(MainActivity);
            });

    }
}