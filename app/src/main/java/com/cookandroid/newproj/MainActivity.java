package com.cookandroid.newproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.newproj.Exercise.exercise;
import com.cookandroid.newproj.Today_Exercise.today_exercise;

public class MainActivity extends AppCompatActivity {

    private Button btn_exercise, btn_today_exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_exercise = findViewById(R.id.btn_exercise);
        btn_today_exercise = findViewById(R.id.btn_today_exercise);

        btn_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, exercise.class);
                startActivity(intent);
            }
        });

        btn_today_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, today_exercise.class);
                startActivity(intent);
            }
        });

    }
}