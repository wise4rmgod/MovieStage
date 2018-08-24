package com.example.multikskills.moviestage;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
   private Button popular,toprated,favourited;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
     /**   ActionBar myActionBar = getSupportActionBar();

        //For hiding android actionbar
        myActionBar.hide(); **/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
        case R.id.favourite:
            //add the function to perform here
            Intent i=new Intent(MainActivity.this,Favourite.class);
            startActivity(i);
            return(true);
        case R.id.popular:
            //add the function to perform here
            Intent p=new Intent(MainActivity.this,Movielist_Activity.class);
            startActivity(p);
            return(true);
        case R.id.toprated:
            //add the function to perform here
            Intent u=new Intent(MainActivity.this,TopRatedMovies.class);
            startActivity(u);
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }
}
