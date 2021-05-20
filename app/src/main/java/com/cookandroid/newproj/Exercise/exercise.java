package com.cookandroid.newproj.Exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookandroid.newproj.Exercise.Exercise_Cycle.routine;
import com.cookandroid.newproj.Exercise.Exercise_TIP.exercise_tip;
import com.cookandroid.newproj.R;

public class exercise extends AppCompatActivity {

    private Button btn_routine, btn_exercise_tip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        btn_routine = findViewById(R.id.btn_routine);
        btn_exercise_tip = findViewById(R.id.btn_exercise_tip);

        btn_routine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exercise.this, routine.class);
                startActivity(intent);
            }
        });

        btn_exercise_tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(exercise.this, exercise_tip.class);
                startActivity(intent);
            }
        });

    }
}