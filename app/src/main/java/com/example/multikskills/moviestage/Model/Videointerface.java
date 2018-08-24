package com.example.multikskills.moviestage.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Videointerface {
    //@GET("/3/movie/{category}")
    //GET movie/{movie_id}/reviews
    @GET("/3/movie/{movie_id}/videos")
    Call<VideoClass> getMovies(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
