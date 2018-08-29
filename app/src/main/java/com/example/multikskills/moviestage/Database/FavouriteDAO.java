package com.example.multikskills.moviestage.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.multikskills.moviestage.Model.MovieResult;
import com.example.multikskills.moviestage.Model.PopularRoomClass;
import com.example.multikskills.moviestage.MovieDetails;

import java.util.List;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FavouriteDAO {

    @Query("select * from movies")
    LiveData<List<FavouriteEntityClass>> loadAllDetails();

    @Insert(onConflict = REPLACE)
    void insert(FavouriteEntityClass favouriteEntityClass);

    @Query("delete from movies")
    void deletechoice();
    @Query("select * from movies where movieid IN (movieid)")
    List<FavouriteEntityClass> givemeid();

    @Delete
    void deletesingle(FavouriteEntityClass favouriteEntityClass);


}
