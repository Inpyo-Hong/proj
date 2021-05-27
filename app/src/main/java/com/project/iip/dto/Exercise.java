package com.project.iip.dto;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Exercise implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String tip;
    private int image1;

    public Exercise() {

    }

    public Exercise(long id, String name, String tip, int image1) {
        this.id = id;
        this.name = name;
        this.tip = tip;
        this.image1 = image1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }
}
