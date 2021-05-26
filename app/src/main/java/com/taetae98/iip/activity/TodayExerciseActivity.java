package com.taetae98.iip.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CalendarView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.taetae98.iip.R;
import com.taetae98.iip.adapter.ScheduleWithExerciseAdapter;
import com.taetae98.iip.dialog.CreateScheduleDialog;
import com.taetae98.iip.dto.Schedule;
import com.taetae98.iip.dto.ScheduleWithExercise;
import com.taetae98.iip.singleton.AppDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class TodayExerciseActivity extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int week;


    private final ScheduleWithExerciseAdapter scheduleWithExerciseAdapter = new ScheduleWithExerciseAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_exercise);
        List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();

        Calendar calendar = new GregorianCalendar();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        week = calendar.get(Calendar.DAY_OF_WEEK);

        Intent intent = getIntent();
        if(!TextUtils.isEmpty(intent.getStringExtra("check"))){
            for(String i: Arrays.asList("mon_1", "mon_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 4, 31, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("wed_1", "wed_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 2, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("fri_1", "fri_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 4, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("mon_1", "mon_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 7, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("wed_1", "wed_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 9, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("fri_1", "fri_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 11, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("mon_1", "mon_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 14, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("wed_1", "wed_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 16, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("fri_1", "fri_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 18, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("mon_1", "mon_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 21, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("wed_1", "wed_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 23, exerciseId, j + 1, 10, false)
                    );
                }
            }
            for(String i: Arrays.asList("fri_1", "fri_2")) {
                long exerciseId = intent.getExtras().getLong(i);
                for (int j = 0; j < 10; j++) {
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, 5, 25, exerciseId, j + 1, 10, false)
                    );
                }
            }
        }
        notifyAdapter();
        onCreateCalendarView();
        onCreateRecyclerView();
        onCreateFloatingActionButton();

    }

    @Override
    public void onResume() {
        super.onResume();
        notifyAdapter();
    }

    private void onCreateCalendarView() {
        CalendarView calendarView = findViewById(R.id.calendar_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            calendarView.setOnDateChangeListener((view, year, month, day) -> {
                this.year = year;
                this.month = month;
                this.day = day;

                notifyAdapter();
            });
        }
    }

    private void onCreateRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(scheduleWithExerciseAdapter);
        List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                list.remove(viewHolder.getAdapterPosition());
                scheduleWithExerciseAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }

    private void onCreateFloatingActionButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.floating_action_button);
        floatingActionButton.setOnClickListener(view -> {
            CreateScheduleDialog dialog = new CreateScheduleDialog(TodayExerciseActivity.this);
            dialog.setCallback((exerciseId, set, rep) -> {
                for (int j=0;j<set;j++){
                    AppDatabase.getInstance(TodayExerciseActivity.this).schedule().insert(
                            new Schedule(0L, year, month, day, exerciseId, j+1, rep, false)
                    );
                }
                notifyAdapter();
            });

            dialog.show();
        });
    }

    private void notifyAdapter() {
        List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            scheduleWithExerciseAdapter.submitList(
                    list.stream().filter(scheduleWithExercise -> scheduleWithExercise.getSchedule().getYear() == year &&
                            scheduleWithExercise.getSchedule().getMonth() == month &&
                            scheduleWithExercise.getSchedule().getDay() == day).collect(Collectors.toList())
            );
        }
    }
}