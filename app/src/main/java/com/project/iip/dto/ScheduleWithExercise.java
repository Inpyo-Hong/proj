package com.project.iip.dto;

import androidx.room.Embedded;
import androidx.room.Relation;

public class ScheduleWithExercise {
    @Embedded
    Schedule schedule;


    @Relation(
            parentColumn = "exerciseId",
            entityColumn = "id"
    )
    Exercise exercise;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
