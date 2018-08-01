package com.example.multikskills.moviestage;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.multikskills.moviestage.Model.Apiclass;
import com.example.multikskills.moviestage.Model.MovieResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movielist_Activity extends AppCompatActivity {
    TabHost tabHost;
    public static String BASE_URL="https://api.themoviedb.org";
    public  static  int PAGE = 1;
    public static String API_KEY ="fcc7df8a640150a6fc5b2f0cc006e2e9";
    public static String LANGUAGE ="en-US";
    public static String CATEGORY ="popular";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist_);
        ActionBar myActionBar = getSupportActionBar();
        //For hiding android actionbar
        myActionBar.hide();
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Apiclass myinterface = retrofit.create(Apiclass.class);
        Call<MovieResult> call = myinterface.getMovies(CATEGORY,API_KEY,LANGUAGE,PAGE);
        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                      MovieResult result =  response.body();
                         List<MovieResult.ResultsBean> listofmovies = result.getResults();
                MovieResult.ResultsBean firstmovies = listofmovies.get(0);
                Toast.makeText(getApplicationContext(),firstmovies.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Popular Movies");
        host.addTab(spec);


        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Highest Rated");
        host.addTab(spec);
    }
}
