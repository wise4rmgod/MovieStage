package com.example.multikskills.moviestage;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class FavouriteDetails extends AppCompatActivity {
    public TextView date,title,overview,rating;
    public ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_details);
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

        date.setText(dateintent);
        title.setText(titleintent);
        overview.setText(overviewintent);
        rating.setText("" + ratingintent);

        Glide.with(this)
                .load(imgurl)
                .centerCrop()
                //.fitCenter()
                .placeholder(R.drawable.errorimage)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .crossFade()
                .into(img);
    }
}
