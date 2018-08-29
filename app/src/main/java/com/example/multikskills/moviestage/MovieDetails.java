package com.example.multikskills.moviestage;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.multikskills.moviestage.Adapter.FavouriteAdapter;
import com.example.multikskills.moviestage.Database.AppDatabase;
import com.example.multikskills.moviestage.Database.FavouriteEntityClass;
import com.example.multikskills.moviestage.Model.VideoClass;
import com.example.multikskills.moviestage.Model.Videointerface;


import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetails extends AppCompatActivity {
  public TextView date,title,overview,rating;
  public ImageView img;
  public Button review;
  public ToggleButton togl;
    public static String BASE_URL="https://api.themoviedb.org";
    public  static  int PAGE = 1;
    public static String API_KEY ="fcc7df8a640150a6fc5b2f0cc006e2e9";
    public static String LANGUAGE ="en-US";
    public static String movie_id ="movie_id";
    public FloatingActionButton fab;
    private AppDatabase mDb;
   public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     //   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final String dateintent = getIntent().getStringExtra("date");
        final String titleintent = getIntent().getStringExtra("title");
        final String overviewintent = getIntent().getStringExtra("overview");
        final int ratingintent = getIntent().getIntExtra("rating", 0);
        final int idintent = getIntent().getIntExtra("id", 0);
        final String imgurl = getIntent().getStringExtra("imgurl");
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(titleintent);


        date = findViewById(R.id.date);
        rating = findViewById(R.id.rating);
        title = findViewById(R.id.titley);
        overview = findViewById(R.id.overview);
        img = findViewById(R.id.imgdetails);
        review = findViewById(R.id.reviewbutton);
         togl=findViewById(R.id.toggle);
        // Toast.makeText(this, (int) ratingintent,Toast.LENGTH_SHORT).show();
      //  mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());
        mDb = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbname").allowMainThreadQueries()
                .build();
        date.setText(dateintent);
        title.setText(titleintent);
        overview.setText(overviewintent);
        rating.setText("" + ratingintent);
        sharedPreferences= PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext());


        togl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    FavouriteEntityClass favouriteEntityClass= new FavouriteEntityClass();
                    favouriteEntityClass.count=ratingintent;
                    favouriteEntityClass.date=dateintent;
                    favouriteEntityClass.favouriteid=idintent;
                    favouriteEntityClass.imgurl=imgurl;
                    favouriteEntityClass.title=titleintent;
                    favouriteEntityClass.movieid=idintent;
                    favouriteEntityClass.overview=overviewintent;
                    mDb.userModel().insert(favouriteEntityClass);

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("saved",titleintent);
                    editor.apply();


                  //  Toast.makeText(MovieDetails.this,"saved successfully",Toast.LENGTH_SHORT).show();

                }
                else {

                    FavouriteEntityClass favouriteEntityClass= new FavouriteEntityClass();
                    favouriteEntityClass.count=ratingintent;
                    favouriteEntityClass.date=dateintent;
                    favouriteEntityClass.favouriteid=idintent;
                    favouriteEntityClass.imgurl=imgurl;
                    favouriteEntityClass.title=titleintent;
                    favouriteEntityClass.movieid=idintent;
                    favouriteEntityClass.overview=overviewintent;
                    mDb.userModel().deletesingle(favouriteEntityClass);
                    sharedPreferences.edit().remove("saved").apply();

                 //   Toast.makeText(MovieDetails.this,"delete Successfully",Toast.LENGTH_SHORT).show();


                }
            }
        });



        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MovieDetails.this,ReviewActivity.class);
                i.putExtra("id",idintent);
                        startActivity(i);
            }
        });

       /** Picasso.get().load(imgurl)
                .placeholder(R.drawable.spiderman)
                .error(R.drawable.errorimage)
                .fit()
                .into(img);  **/

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        // this is for popular movies from moviedb api

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Videointerface myinterface = retrofit.create(Videointerface.class);
        Call<VideoClass> call = myinterface.getMovies(idintent, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<VideoClass>() {
            @Override
            public void onResponse(Call<VideoClass> call, Response<VideoClass> response) {
                VideoClass result = (VideoClass) response.body();
                List<VideoClass.ResultsBean> listofmovies = result.getResults();
                final VideoClass.ResultsBean firstmovies = listofmovies.get(1);
                // PopularMovieAdapter adapter= new PopularMovieAd);

               /** Toast.makeText(getApplicationContext(), firstmovies.getKey(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + firstmovies.getKey()));
                intent.putExtra("VIDEO_ID", firstmovies.getKey());
                startActivity(intent);  **/

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (firstmovies.getKey() == null){
                            Toast.makeText(MovieDetails.this,"Video not avaliable",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + firstmovies.getKey()));

                            startActivity(intent);
                        }
                    }
                });


            }

            @Override
            public void onFailure(Call<VideoClass> call, Throwable t) {

            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final String titleintent = getIntent().getStringExtra("title");
               if(sharedPreferences.getString("saved", "paul").equals(titleintent)){
            togl.setChecked(true);

               }
    }
}
