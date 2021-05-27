package com.project.iip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.project.iip.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class cycle_a extends AppCompatActivity {
    private Button btn_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cycle_a);

        btn_enroll = findViewById(R.id.btn_enroll);

        btn_enroll.setOnClickListener(view -> {
            Date currentTime = Calendar.getInstance().getTime();
            SimpleDateFormat weekdayFormat = new SimpleDateFormat("EE", Locale.getDefault());
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
            SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

            String weekDay = weekdayFormat.format(currentTime);
            int day = Integer.parseInt(dayFormat.format(currentTime));
            int month = Integer.parseInt(monthFormat.format(currentTime));
            int year = Integer.parseInt(yearFormat.format(currentTime));

            Intent intent = new Intent(cycle_a.this, TodayExerciseActivity.class);

            intent.putExtra("check", "start");

            intent.putExtra("mon_1", 1L);
            intent.putExtra("mon_2", 3L);


            intent.putExtra("wed_1", 1L);
            intent.putExtra("wed_2", 2L);


            intent.putExtra("fri_1", 2L);
            intent.putExtra("fri_2", 3L);

            startActivity(intent);
        });
    }
}
