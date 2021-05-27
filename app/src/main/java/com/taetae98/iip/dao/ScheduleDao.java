package com.taetae98.iip.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.taetae98.iip.base.BaseDao;
import com.taetae98.iip.dto.Schedule;
import com.taetae98.iip.dto.ScheduleWithExercise;

import java.util.List;

@Dao
public interface ScheduleDao extends BaseDao<Schedule> {
    @Query("SELECT * FROM Schedule")
    List<ScheduleWithExercise> selectWithExerciseList();

    @Query("SELECT * FROM Schedule WHERE year = :year AND month = :month AND day = :day AND exerciseId = :exerciseId")
    List<Schedule> selectWithDateAndExerciseId(int year, int month, int day, long exerciseId);
}
