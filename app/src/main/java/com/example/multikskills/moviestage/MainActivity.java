package com.example.multikskills.moviestage;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button popular,toprated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar myActionBar = getSupportActionBar();

        //For hiding android actionbar
        myActionBar.hide();
        popular = findViewById(R.id.popular);
        toprated = findViewById(R.id.toprated);
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Movielist_Activity.class);
                startActivity(i);
            }
        });

        toprated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,TopRatedMovies.class);
                startActivity(i);
            }
        });
    }
}
