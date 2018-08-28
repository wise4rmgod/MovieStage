package com.example.multikskills.moviestage;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.multikskills.moviestage.Adapter.HighestRatedMovieAdapter;
import com.example.multikskills.moviestage.Adapter.PopularMovieAdapter;
import com.example.multikskills.moviestage.Model.Apiclass;
import com.example.multikskills.moviestage.Model.MovieResult;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movielist_Activity extends AppCompatActivity {

    public static String BASE_URL="https://api.themoviedb.org";
    public  static  int PAGE = 1;
    public static String API_KEY ="fcc7df8a640150a6fc5b2f0cc006e2e9";
    public static String LANGUAGE ="en-US";
    public static String CATEGORY ="popular";
    public AVLoadingIndicatorView avi;
    private static Bundle mBundleRecyclerViewState;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    Parcelable recyclerViewState;
    public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist_);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle("Popular Movies");
        //For hiding android actionbar
       // myActionBar.hide();
        avi= findViewById(R.id.avi);
        avi.show();
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else {
            avi.hide();
            connected = false;
            Toast.makeText(this, "No Network Connection", Toast.LENGTH_SHORT).show();
        }

        // get the reference of RecyclerView
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView


        // this is for popular movies from moviedb api

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiclass myinterface = retrofit.create(Apiclass.class);
        Call<MovieResult> call = myinterface.getMovies(CATEGORY,API_KEY,LANGUAGE,PAGE);
        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                      MovieResult result = (MovieResult) response.body();
                         List<MovieResult.ResultsBean> listofmovies = result.getResults();
                 MovieResult.ResultsBean firstmovies = listofmovies.get(1);
               // PopularMovieAdapter adapter= new PopularMovieAd);
                avi.hide();
                recyclerView.setAdapter(new PopularMovieAdapter(getApplicationContext(),listofmovies));
             //   Toast.makeText(getApplicationContext(),firstmovies.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });

    }

   /**
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        recyclerViewState= recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable("work",recyclerViewState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null)
            recyclerViewState = savedInstanceState.getParcelable("work");

    }  **/

}
