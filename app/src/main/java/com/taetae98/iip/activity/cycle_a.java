package com.taetae98.iip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.taetae98.iip.R;

public class cycle_a extends AppCompatActivity {
    private Button btn_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_a);

        btn_enroll = findViewById(R.id.btn_enroll);

        btn_enroll.setOnClickListener(view -> {
            startActivity(new Intent(cycle_a.this, TodayExerciseActivity.class));
        });
    }
}
