package com.project.iip.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.iip.R;
import com.project.iip.activity.Exercise_TIP.Tip.tip_pullup;
import com.project.iip.activity.Exercise_TIP.Tip.tip_pushup;
import com.project.iip.activity.Exercise_TIP.Tip.tip_squat;
import com.project.iip.dto.Exercise;

public class ExerciseInformationActivity extends AppCompatActivity {
    private Exercise exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise_information);

        exercise = (Exercise) (getIntent().getSerializableExtra("exercise"));

        switch (exercise.getName()){
            case "스쿼트":
                Intent intent = new Intent(ExerciseInformationActivity.this, tip_squat.class);
                startActivity(intent);
                break;
            case "푸쉬업":
                Intent intent1 = new Intent(ExerciseInformationActivity.this, tip_pushup.class);
                startActivity(intent1);
                break;
            case  "풀업" :
                Intent intent2 = new Intent(ExerciseInformationActivity.this, tip_pullup.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
        //onCreateTextView();
        //onCreateTipTextView();
        //onCreateImageView();
    }

    private void onCreateTextView() { //운동 팁페이지 운동이름(제목)
        TextView textView = findViewById(R.id.text_view);
        textView.setText(exercise.getName());
    }

    private void onCreateTipTextView() { //운동 팁페이지 내용
        TextView textView = findViewById(R.id.tip_text_view);
        textView.setText(exercise.getTip());
    }

    private void onCreateImageView() {
        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageResource(exercise.getImage1());
    }
}