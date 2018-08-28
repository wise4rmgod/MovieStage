package com.example.multikskills.moviestage.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "movies")
public class FavouriteEntityClass {

    @PrimaryKey(autoGenerate = true)
    public long favouriteid;

    public String title;

    public String overview;

    public String imgurl;

    public int movieid;

    public int count;

    public String date;




}
