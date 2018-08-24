package com.example.multikskills.moviestage.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface FavouriteDAO {

    @Query("select * from movies")
    List<FavouriteEntityClass> loadAllDetails();

    @Insert(onConflict = REPLACE)
    void insert(FavouriteEntityClass favouriteEntityClass);

    @Query("delete from movies")
    void deletechoice();

    @Delete
    void deletesingle(FavouriteEntityClass favouriteEntityClass);


}
