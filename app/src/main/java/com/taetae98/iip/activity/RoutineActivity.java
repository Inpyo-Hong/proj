package com.taetae98.iip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.taetae98.iip.R;

public class RoutineActivity extends AppCompatActivity {

    private Button btn_cycle_a, btn_cycle_b, btn_cycle_c, btn_cycle_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        btn_cycle_a = findViewById(R.id.btn_a);
        btn_cycle_b = findViewById(R.id.btn_b);
        btn_cycle_c = findViewById(R.id.btn_c);
        btn_cycle_d = findViewById(R.id.btn_d);

        btn_cycle_a.setOnClickListener(view -> {
            startActivity(new Intent(RoutineActivity.this, cycle_a.class));
        });
        btn_cycle_b.setOnClickListener(view -> {
            startActivity(new Intent(RoutineActivity.this, cycle_b.class));
        });
        btn_cycle_c.setOnClickListener(view -> {
            startActivity(new Intent(RoutineActivity.this, cycle_c.class));
        });
        btn_cycle_d.setOnClickListener(view -> {
            startActivity(new Intent(RoutineActivity.this, cycle_d.class));
        });
    }
}