package com.cookandroid.newproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exercise_tip extends AppCompatActivity {
    Button btn_squat,btn_pushup,btn_pullup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_tip);
        btn_pushup = findViewById(R.id.btn_pushup);
        btn_pullup = findViewById(R.id.btn_pullup);
        btn_squat = findViewById(R.id.btn_squat);

        btn_pushup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(exercise_tip.this, tip_pushup.class);
                startActivity(intent);
            }
        });
        btn_pullup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(exercise_tip.this, tip_pullup.class);
                startActivity(intent);
            }
        });
        btn_squat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(exercise_tip.this, tip_squat.class);
                startActivity(intent);
            }
        });
    }
}