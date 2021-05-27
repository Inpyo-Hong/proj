package com.project.iip.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.project.iip.base.BaseDao;
import com.project.iip.dto.Schedule;
import com.project.iip.dto.ScheduleWithExercise;

import java.util.List;

@Dao
public interface ScheduleDao extends BaseDao<Schedule> {
    @Query("SELECT * FROM Schedule")
    List<ScheduleWithExercise> selectWithExerciseList();

    @Query("SELECT * FROM Schedule WHERE year = :year AND month = :month AND day = :day AND exerciseId = :exerciseId")
    List<Schedule> selectWithDateAndExerciseId(int year, int month, int day, long exerciseId);
}
