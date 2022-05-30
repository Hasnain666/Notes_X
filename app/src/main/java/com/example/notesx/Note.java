package com.example.notesx;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "my_notes")
public class Note {
    private String title;
    private String discription;
    @PrimaryKey(autoGenerate = true)
    private int id;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Note(String title, String discription) {
        this.title = title;
        this.discription = discription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
