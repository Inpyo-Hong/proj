package com.taetae98.iip.dto;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Exercise.class,
                        parentColumns = {"id"},
                        childColumns = {"exerciseId"},
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                )
        }
)
public class Schedule {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int year;
    private int month;
    private int day;
    private long exerciseId;
    private int set;
    private int rep;

    public Schedule(long id, int year, int month, int day, long exerciseId, int set, int rep) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.exerciseId = exerciseId;
        this.set = set;
        this.rep = rep;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }
}
