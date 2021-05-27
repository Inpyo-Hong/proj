package com.project.iip.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.project.iip.R;
import com.project.iip.adapter.ExerciseAdapter;
import com.project.iip.dialog.CreateScheduleDialog;
import com.project.iip.dialog.RoutineDialog;
import com.project.iip.dto.Exercise;
import com.project.iip.dto.Schedule;
import com.project.iip.dto.ScheduleWithExercise;
import com.project.iip.singleton.AppDatabase;

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

    private ExerciseAdapter exerciseAdapter = new ExerciseAdapter();

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

        onCreateSupportActionBar();
        onCreateCalendarView();
        onCreateRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_today_exercise, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
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
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onCreateSupportActionBar() {
        setSupportActionBar(findViewById(R.id.toolbar));
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
        notifyAdapter();

        exerciseAdapter.setOnExerciseClick(exercise -> {
            List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();
            RoutineDialog dialog = new RoutineDialog(this);
            dialog.setList(list.stream().filter(scheduleWithExercise -> {
                Schedule schedule = scheduleWithExercise.getSchedule();
                return (schedule.getYear() == year) &&
                        (schedule.getMonth() == month) &&
                        (schedule.getDay() == day) &&
                        (schedule.getExerciseId() == exercise.getId());
            }).collect(Collectors.toList()));

            dialog.show();
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(exerciseAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if (viewHolder instanceof ExerciseAdapter.ExerciseHolder) {
                    Exercise exercise = ((ExerciseAdapter.ExerciseHolder) viewHolder).element;
                    List<Schedule> eraseList = AppDatabase.getInstance(TodayExerciseActivity.this).schedule().selectWithDateAndExerciseId(
                            year, month, day, exercise.getId()
                    );

                    eraseList.forEach(schedule -> {
                        AppDatabase.getInstance(TodayExerciseActivity.this).schedule().delete(schedule);
                    });

                    notifyAdapter();
                }
            }
        }).attachToRecyclerView(recyclerView);
    }

    public void notifyAdapter() {
        List<ScheduleWithExercise> list = AppDatabase.getInstance(this).schedule().selectWithExerciseList();

        List<Exercise> exerciseList = list.stream()
                .filter(scheduleWithExercise -> {
                    Schedule schedule = scheduleWithExercise.getSchedule();
                    return schedule.getYear() == year && schedule.getMonth() == month && schedule.getDay() == day;
                })
                .map(ScheduleWithExercise::getExercise)
                .distinct()
                .collect(Collectors.toList());

        exerciseAdapter.submitList(exerciseList);
    }
}