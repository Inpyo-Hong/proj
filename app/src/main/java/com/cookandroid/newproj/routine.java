package com.cookandroid.newproj;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.cookandroid.newproj.Today_Exercise.today_exercise;

public class routine extends AppCompatActivity {

    private Button btn_cycle_a,btn_cycle_b,btn_cycle_c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);
        btn_cycle_a = findViewById(R.id.btn_cycle_a);
        btn_cycle_b = findViewById(R.id.btn_cycle_b);
        btn_cycle_c = findViewById(R.id.btn_cycle_c);

        btn_cycle_a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(routine.this, cycle_a.class);
                startActivity(intent);
            }
        });
        btn_cycle_b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(routine.this, cycle_b.class);
                startActivity(intent);
            }
        });
        btn_cycle_c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(routine.this, cycle_c.class);
                startActivity(intent);
            }
        });

    }
}