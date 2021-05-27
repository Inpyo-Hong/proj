package com.project.iip.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.project.iip.R;
import com.project.iip.adapter.ExerciseAdapter;
import com.project.iip.singleton.AppDatabase;

public class TipActivity extends AppCompatActivity {
    private final ExerciseAdapter exerciseAdapter = new ExerciseAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        onCreateRecyclerView();
    }

    private void onCreateRecyclerView() {
        AppDatabase.getInstance(this).exercise().select().observe(this, exerciseAdapter::submitList);
        exerciseAdapter.setOnExerciseClick(exercise -> {
            startActivity(new Intent(this, ExerciseInformationActivity.class).putExtra("exercise", exercise));
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(exerciseAdapter);
    }
}