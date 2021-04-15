package com.example.jokes.DevLife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.jokes.R;
import com.example.jokes.databinding.ActivityDevLifeBinding;

import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DevLife extends AppCompatActivity {
    ActivityDevLifeBinding binding;

    JokeInterface jokeInterface;
    protected static Stack<Integer> prePost =new Stack<>();
    private String logoUrl = "https://developerslife.ru/images/logoru.png";


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
        setContentView(R.layout.activity_dev_life);
        binding = ActivityDevLifeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent MainActivity = new Intent(this, com.example.jokes.MainActivity.class);

        if(isOnline()) {
        ImageView ImageView = (ImageView) findViewById(R.id.imageView);
        Glide
                .with(DevLife.this)
                .load(logoUrl)
                .into(ImageView);
        binding.textView.setText("Developer's life");
        getSupportActionBar().hide();

        jokeInterface = APIDevLife.getClient().create(JokeInterface.class);

        binding.btnNext.setOnClickListener(V ->{
            Call<Joke> call = jokeInterface.getRandomJoke();
            call.enqueue(new Callback<Joke>() {
                @Override
                public void onResponse(Call<Joke> call, Response<Joke> response) {
                    Joke randomJoke = response.body();
                    binding.textView.setText(randomJoke.getDescription());

                    Glide
                            .with(DevLife.this)
                            .asGif()
                            .load(randomJoke.getGifURL())
                            .into(ImageView);

                    prePost.push(randomJoke.getId());

                }

                @Override
                public void onFailure(Call<Joke> call, Throwable t) {
                    Toast.makeText(DevLife.this, "sorry, something is wrong", Toast.LENGTH_LONG)
                            .show();
                    binding.textView.setText(R.string.notNetworkConnection);
                }
            });
        });

        binding.btnPrevious.setOnClickListener(v -> {
            if(!(prePost.isEmpty())) {
                prePost.pop();
                if(!(prePost.isEmpty())) {
                    Call<Joke> call = jokeInterface.getPost(prePost.peek().toString());
                    call.enqueue(new Callback<Joke>() {
                        @Override
                        public void onResponse(Call<Joke> call, Response<Joke> response) {
                            Joke joke = response.body();
                            prePost.peek();
                            binding.textView.setText(joke.getDescription());
                            Glide
                                    .with(DevLife.this)
                                    .asGif()
                                    .load(joke.getGifURL())
                                    .into(ImageView);
                        }

                        @Override
                        public void onFailure(Call<Joke> call, Throwable t) {
                            binding.textView.setText(R.string.notNetworkConnection);
                        }
                    });
                }
            }
        });

    }else{
        binding.textView.setText(R.string.notNetworkConnection);
    }

        binding.back.setOnClickListener(V ->{
            startActivity(MainActivity);
        });
    }
}