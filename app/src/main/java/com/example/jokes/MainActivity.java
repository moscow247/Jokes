package com.example.jokes;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.example.jokes.Chuck.Chuck;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnDevLife = (Button) findViewById(R.id.btnDevLife);
        Button btnChuck = (Button) findViewById(R.id.btnChuck);


        getSupportActionBar().hide();


        Intent DevLife = new Intent(MainActivity.this, com.example.jokes.DevLife.DevLife.class);
        Intent ChuckActivity = new Intent(this, Chuck.class);


        btnDevLife.setOnClickListener(V -> {
            startActivity(DevLife);
        });

        btnChuck.setOnClickListener(v -> {
            startActivity(ChuckActivity);
        });

    }
}
