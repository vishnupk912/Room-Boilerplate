package com.mvvm.room_mvvm.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "Notes_table")
public class Notes
{
    @PrimaryKey(autoGenerate =true)
    int id;

    private  String title;

    private  String description;


    private  int priority;


    public Notes(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
