package com.taetae98.iip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.taetae98.iip.R;
import com.taetae98.iip.dto.Exercise;

public class ExerciseInformationActivity extends AppCompatActivity {
    private Exercise exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_information);

        exercise = (Exercise) (getIntent().getSerializableExtra("exercise"));

        onCreateTextView();
        onCreateTipTextView();
        onCreateImageView();
    }

    private void onCreateTextView() {
        TextView textView = findViewById(R.id.text_view);
        textView.setText(exercise.getName());
    }

    private void onCreateTipTextView() {
        TextView textView = findViewById(R.id.tip_text_view);
        textView.setText(exercise.getTip());
    }

    private void onCreateImageView() {
        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(exercise.getImage1());
    }
}