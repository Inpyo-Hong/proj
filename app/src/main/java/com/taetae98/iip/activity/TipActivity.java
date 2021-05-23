package com.taetae98.iip.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.taetae98.iip.R;
import com.taetae98.iip.adapter.ExerciseAdapter;
import com.taetae98.iip.dto.Exercise;
import com.taetae98.iip.singleton.AppDatabase;

import java.util.List;

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
        
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(exerciseAdapter);
    }
}