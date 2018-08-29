package com.example.multikskills.moviestage.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "popularmovies")
public class PopularRoomClass {

    @PrimaryKey(autoGenerate = true)
    public long favouriteid;

    public String title;

    public String overview;

    public String imgurl;

    public int movieid;

    public int count;

    public String date;
}
