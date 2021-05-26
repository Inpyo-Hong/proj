package com.taetae98.iip.dto;

import android.os.Parcel;
import android.os.Parcelable;

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
public class Schedule implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int year;
    private int month;
    private int day;
    private long exerciseId;
    private int set;
    private int rep;
    private boolean done;

    public Schedule(long id, int year, int month, int day, long exerciseId, int set, int rep, boolean done) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.exerciseId = exerciseId;
        this.set = set;
        this.rep = rep;
        this.done = done;
    }

    protected Schedule(Parcel in) {
        id = in.readLong();
        year = in.readInt();
        month = in.readInt();
        day = in.readInt();
        exerciseId = in.readLong();
        set = in.readInt();
        rep = in.readInt();
        done = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(year);
        dest.writeInt(month);
        dest.writeInt(day);
        dest.writeLong(exerciseId);
        dest.writeInt(set);
        dest.writeInt(rep);
        dest.writeByte((byte) (done ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel in) {
            return new Schedule(in);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };

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

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
