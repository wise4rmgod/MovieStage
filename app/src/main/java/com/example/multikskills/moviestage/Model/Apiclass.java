package com.example.multikskills.moviestage.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Apiclass {
    @GET("/3/movie/{category}")
    Call<MovieResult> getMovies(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
