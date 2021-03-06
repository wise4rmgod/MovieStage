package com.example.multikskills.moviestage.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multikskills.moviestage.Model.MovieResult;
import com.example.multikskills.moviestage.MovieDetails;
import com.example.multikskills.moviestage.R;


import java.util.List;

public class HighestRatedMovieAdapter extends RecyclerView.Adapter<HighestRatedMovieAdapter.MyViewHolder> {

    private List<MovieResult.ResultsBean> movies;
    public Context mContext;



    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;



        public MyViewHolder(View view) {
            super(view);
            //initialize buttons and TextViews
            // title =  view.findViewById(R.id.title);
            img=  view.findViewById(R.id.img1);



        }
    }

    //constructor
    public HighestRatedMovieAdapter(Context mContext, List<MovieResult.ResultsBean> movies) {
        this.movies = movies;
        this.mContext = mContext;
    }

    @Override
    public HighestRatedMovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //set layout to itemView using Layout inflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.highestrated, parent, false);
        return new HighestRatedMovieAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HighestRatedMovieAdapter.MyViewHolder holder, final int position) {

        final MovieResult.ResultsBean moviesz = movies.get(position);
        //   holder.title.setText(journals.getTitle());

        //Glide.with(mContext).load(moviesz.getPoster_path()).into(holder.img);
        // "http://i.imgur.com/DvpvklR.png"
      /**  Picasso.get().load(R.drawable.spiderman)
                .placeholder(R.drawable.spiderman)
                .error(R.drawable.errorimage)
                .fit()
                //  .resize(300, 300)
                .into(holder.img);  **/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,""+moviesz.getId(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(mContext, MovieDetails.class);
                //pass data though intent using puExtra
                i.putExtra("title", moviesz.getOriginal_title());
                i.putExtra("overview",moviesz.getOverview());
                i.putExtra("date", moviesz.getRelease_date());
                i.putExtra("rating", moviesz.getVote_count());
                i.putExtra("imgurl",moviesz.getPoster_path());
                mContext.startActivity(i);

            }
        });

/**
 //Click listener of button delete
 holder.delete.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
//point databaseReference to Movies
database = FirebaseDatabase.getInstance().getReference("journal");
//remove value of child movie.getKey()
database.child(journals.getKey()).setValue(null);
//remove item from list
journal.remove(position);
//notofy datachanged to adapter
notifyItemRemoved(position);
notifyItemRangeChanged(position, journal.size());
Toast.makeText(mContext, "Item Deleted", Toast.LENGTH_SHORT).show();

}
});

 //Click listener of Button Edit
 holder.edit.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent i = new Intent(mContext, EditEntryActivity.class);
//pass data though intent using puExtra
i.putExtra("title", journals.getTitle());
i.putExtra("message",journals.getMessage());
i.putExtra("date", journals.getDate());
i.putExtra("key", journals.getKey());
mContext.startActivity(i);
}
});  **/
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
