package com.project.iip.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.project.iip.base.BaseDao;
import com.project.iip.dto.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao extends BaseDao<Exercise> {
    @Query("SELECT * FROM Exercise")
    LiveData<List<Exercise>> select();

    @Query("SELECT * FROM Exercise")
    List<Exercise> selectData();
}
