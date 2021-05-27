package com.project.iip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.project.iip.R;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        onCreateRoutineButton();
        onCreateTipButton();
    }

    private void onCreateRoutineButton() {
        Button routineButton = findViewById(R.id.routine_button);
        routineButton.setOnClickListener(view -> {
            startActivity(new Intent(ExerciseActivity.this, RoutineActivity.class));
        });
    }

    private void onCreateTipButton() {
        Button tipButton = findViewById(R.id.tip_button);
        tipButton.setOnClickListener(view -> {
            startActivity(new Intent(ExerciseActivity.this, TipActivity.class));
        });
    }
}