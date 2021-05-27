package com.project.iip.base;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Transaction;
import androidx.room.Update;

@Dao
public interface BaseDao<E> {
    @Transaction
    @Insert
    void insert(E... arg);

    @Transaction
    @Update
    void update(E... arg);

    @Transaction
    @Delete
    void delete(E... arg);
}
