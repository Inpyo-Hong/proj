package com.project.iip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.project.iip.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateExerciseButton();
        onCreateTodayExerciseButton();
    }

    private void onCreateExerciseButton() {
        Button exerciseButton = findViewById(R.id.exercise_button);
        exerciseButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ExerciseActivity.class)));
    }

    private void onCreateTodayExerciseButton() {
        Button todayExerciseButton = findViewById(R.id.today_exercise_button);
        todayExerciseButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TodayExerciseActivity.class)));
    }
}