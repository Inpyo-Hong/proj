package com.cookandroid.newproj.Today_Exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.newproj.R;
import com.cookandroid.newproj.Today_Exercise.Camera.CameraActivity;

public class today_exercise extends AppCompatActivity {

    private Button btn_today_squat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_exercise);

        btn_today_squat = findViewById(R.id.btn_today_squat);

        btn_today_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(today_exercise.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }
}