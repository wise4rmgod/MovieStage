package com.example.multikskills.moviestage;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.multikskills.moviestage.Adapter.FavouriteAdapter;
import com.example.multikskills.moviestage.Database.AppDatabase;
import com.example.multikskills.moviestage.Database.FavouriteEntityClass;

import java.util.List;

public class Favourite extends AppCompatActivity {
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setTitle("Popular Movies");
        //For hiding android actionbar
        // myActionBar.hide();

        mDb = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "dbname").build();

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            // we are connected to a network
            connected = true;

        }
        else {

            connected = false;

            Toast.makeText(this, "No Network Connection", Toast.LENGTH_SHORT).show();
        }

        // get the reference of RecyclerView
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a GridLayoutManager with default vertical orientation and 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        final LiveData<List<FavouriteEntityClass>> favlist= mDb.userModel().loadAllDetails();
        favlist.observe(this, new Observer<List<FavouriteEntityClass>>() {
            @Override
            public void onChanged(@Nullable List<FavouriteEntityClass> favouriteEntityClasses) {
                recyclerView.setAdapter(new FavouriteAdapter(getApplicationContext(), favouriteEntityClasses));
            }
        });


    }
}
