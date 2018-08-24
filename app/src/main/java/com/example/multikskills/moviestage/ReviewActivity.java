package com.example.multikskills.moviestage;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.multikskills.moviestage.Adapter.PopularMovieAdapter;
import com.example.multikskills.moviestage.Adapter.ReviewAdapter;
import com.example.multikskills.moviestage.Model.Apiclass;
import com.example.multikskills.moviestage.Model.MovieResult;
import com.example.multikskills.moviestage.Model.ReviewClass;
import com.example.multikskills.moviestage.Model.Reviewinterface;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReviewActivity extends AppCompatActivity {
    public static String BASE_URL="https://api.themoviedb.org";
    public  static  int PAGE = 1;
    public static String API_KEY ="fcc7df8a640150a6fc5b2f0cc006e2e9";
    public static String LANGUAGE ="en-US";
    public static String movie_id ="movie_id";
    public AVLoadingIndicatorView avi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        final int idintent = getIntent().getIntExtra("id", 0);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle("Reviews");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
       // GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
       // recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Reviewinterface myinterface = retrofit.create(Reviewinterface.class);
        Call<ReviewClass> call = myinterface.getMovies(idintent,API_KEY,LANGUAGE,PAGE);
        call.enqueue(new Callback<ReviewClass>() {
            @Override
            public void onResponse(Call<ReviewClass> call, Response<ReviewClass> response) {
                ReviewClass result = (ReviewClass) response.body();
                List<ReviewClass.ResultsBean> listofmovies = result.getResults();
               // ReviewClass.ResultsBean firstmovies = listofmovies.get(1);
                // PopularMovieAdapter adapter= new PopularMovieAd);
                avi.hide();
                recyclerView.setAdapter(new ReviewAdapter(getApplicationContext(),listofmovies));
                //   Toast.makeText(getApplicationContext(),firstmovies.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ReviewClass> call, Throwable t) {

            }
        });
    }
}
