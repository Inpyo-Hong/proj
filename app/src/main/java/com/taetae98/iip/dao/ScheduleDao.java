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
}
