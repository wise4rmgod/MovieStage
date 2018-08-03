package com.example.multikskills.moviestage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
  public TextView date,title,overview,rating;
  public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String dateintent =getIntent().getStringExtra("date");
        String titleintent = getIntent().getStringExtra("title");
        String overviewintent = getIntent().getStringExtra("overview");
        int  ratingintent = getIntent().getIntExtra("rating",0);
        String imgurl =getIntent().getStringExtra("imgurl");
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle(titleintent);

        date = findViewById(R.id.date);
        rating = findViewById(R.id.rating);
        title = findViewById(R.id.titley);
        overview = findViewById(R.id.overview);
        img = findViewById(R.id.imgdetails);
       // Toast.makeText(this, (int) ratingintent,Toast.LENGTH_SHORT).show();

        date.setText(dateintent);
        title.setText(titleintent);
        overview.setText(overviewintent);
        rating.setText(""+ratingintent);

        Picasso.get().load(imgurl)
                .placeholder(R.drawable.spiderman)
                .error(R.drawable.errorimage)
                .fit()
                .into(img);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "check back later for more info", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
