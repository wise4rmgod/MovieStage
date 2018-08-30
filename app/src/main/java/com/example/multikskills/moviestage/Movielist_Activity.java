package com.example.multikskills.moviestage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.multikskills.moviestage.Adapter.PopularMovieAdapter;
import com.example.multikskills.moviestage.Database.AppDatabase;
import com.example.multikskills.moviestage.Model.Apiclass;
import com.example.multikskills.moviestage.Model.MovieResult;
import com.wang.avi.AVLoadingIndicatorView;
import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
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
    private final String KEY_RECYCLER_STATE = "recycler_state";
    public GridLayoutManager gridLayoutManager;
    public  String RECYCLER_VIEW_POSITION="joli";
    public RecyclerView recyclerView;
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movielist_);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle("Popular Movies");
        //For hiding android actionbar
       // myActionBar.hide();
     /**   mDb = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbname").allowMainThreadQueries()
                .build(); **/
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
       gridLayoutManager  = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView


        // this is for popular movies from moviedb api
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(getCacheDir(), cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
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
            /**    PopularRoomClass moviesresult = new PopularRoomClass();
                                       moviesresult.date;
                                       moviesresult.title;
                                       moviesresult.imgurl;
                                       mDb.userModel().insertpopular(moviesresult);  **/
                recyclerView.setAdapter(new PopularMovieAdapter(getApplicationContext(),listofmovies));
             //   Toast.makeText(getApplicationContext(),firstmovies.getTitle(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {
               Toast.makeText(Movielist_Activity.this,"bad network",Toast.LENGTH_SHORT).show();
            }
        });

    }

  /**  @Override
    protected void onResume() {
        super.onResume();
        List<PopularRoomClass> favlist= mDb.userModel().loadAlpopular();
        //
        for (PopularRoomClass fav : favlist){

            recyclerView.setAdapter(new PopularRoomAdapter(getApplicationContext(),favlist));

        }
    }  **/
}
