package com.example.jokes.DevLife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    protected static Stack<PreviousPost> prePost =new Stack<>();
    private String logoUrl = "https://developerslife.ru/images/logoru.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_life);
        binding = ActivityDevLifeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent MainActivity = new Intent(this, com.example.jokes.MainActivity.class);


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
                    prePost.push(new PreviousPost(randomJoke.getDescription(), randomJoke.getGifURL()));

                }

                @Override
                public void onFailure(Call<Joke> call, Throwable t) {
                    Toast.makeText(DevLife.this, "sorry, something is wrong", Toast.LENGTH_LONG)
                            .show();
                    binding.textView.setText("Извиняюсь, сударь, но кажется у вас нет подключения к сети!");
                }
            });
        });

        binding.btnPrevious.setOnClickListener(v -> {
            if(!(prePost.isEmpty())) {
                prePost.pop();
                if(!(prePost.isEmpty())) {
                    binding.textView.setText(prePost.peek().getTextDescription());
                    Glide
                            .with(DevLife.this)
                            .asGif()
                            .load(prePost.pop().getGifURL())
                            .into(ImageView);
                }
            }
        });

        binding.back.setOnClickListener(V ->{
            startActivity(MainActivity);
        });
    }
}