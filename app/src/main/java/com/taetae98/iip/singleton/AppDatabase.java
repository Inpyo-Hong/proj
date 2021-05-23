package com.taetae98.iip.singleton;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.taetae98.iip.R;
import com.taetae98.iip.dao.ExerciseDao;
import com.taetae98.iip.dao.ScheduleDao;
import com.taetae98.iip.dto.Exercise;
import com.taetae98.iip.dto.Schedule;

@Database(entities = {Exercise.class, Schedule.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "IIP")
                .allowMainThreadQueries()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        new Thread(() -> {
                            getInstance(context).exercise().insert(
                                    new Exercise(1L, "스쿼트", "123", R.drawable.ic_exercise),
                                    new Exercise(2L, "푸쉬업", "456", R.drawable.ic_exercise),
                                    new Exercise(3L, "풀업", "789", R.drawable.ic_exercise)
                            );
                        }).start();
                    }
                }).build();
    }

    public abstract ExerciseDao exercise();
    public abstract ScheduleDao schedule();
}
