package com.taetae98.iip.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.taetae98.iip.base.BaseDao;
import com.taetae98.iip.dto.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao extends BaseDao<Exercise> {
    @Query("SELECT * FROM Exercise")
    LiveData<List<Exercise>> select();

    @Query("SELECT * FROM Exercise")
    List<Exercise> selectData();
}
