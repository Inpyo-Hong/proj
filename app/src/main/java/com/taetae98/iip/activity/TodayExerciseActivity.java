package com.taetae98.iip.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.taetae98.iip.R;
import com.taetae98.iip.adapter.ScheduleWithExerciseAdapter;
import com.taetae98.iip.dialog.CreateScheduleDialog;
import com.taetae98.iip.dto.Schedule;
import com.taetae98.iip.dto.ScheduleWithExercise;
import com.taetae98.iip.singleton.AppDatabase;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class TodayExerciseActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;


    private final ScheduleWithExerciseAdapter scheduleWithExerciseAdapter = new ScheduleWithExerciseAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_exercise);

        Calendar calendar = new GregorianCalendar();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        notifyAdapter();
        onCreateCalendarView();
        onCreateRecyclerView();
        onCreateFloatingActionButton();
    }

    private void onCreateCalendarView() {
        CalendarView calendarView = findViewById(R.id.calendar_view);
        calendarView.setOnDateChangeListener((view, year, month, day) -> {
            this.year = year;
            this.month = month;
            this.day = day;

            notifyAdapter();
        });
    }

    private void onCreateRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(scheduleWithExerciseAdapter);
    }

    private void onCreateFloatingActionButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(view -> {
            CreateScheduleDialog dialog = new CreateScheduleDialog(TodayExerciseActivity.this);
            dialog.setCallback((exerciseId, set, rep) -> {
                AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                        new Schedule(0L, year, month, day, exerciseId, set, rep)
                );
                notifyAdapter();
            });

            dialog.show();
        });
    }

    private void notifyAdapter() {
        List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();

        scheduleWithExerciseAdapter.submitList(
                list.stream().filter(scheduleWithExercise -> scheduleWithExercise.getSchedule().getYear() == year &&
                        scheduleWithExercise.getSchedule().getMonth() == month &&
                        scheduleWithExercise.getSchedule().getDay() == day).collect(Collectors.toList())
        );
    }
}