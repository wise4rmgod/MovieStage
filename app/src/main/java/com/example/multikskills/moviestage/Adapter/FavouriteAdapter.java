package com.example.multikskills.moviestage.Adapter;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.multikskills.moviestage.Database.FavouriteEntityClass;
import com.example.multikskills.moviestage.FavouriteDetails;
import com.example.multikskills.moviestage.Model.MovieResult;
import com.example.multikskills.moviestage.MovieDetails;
import com.example.multikskills.moviestage.R;


import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {

    private List<FavouriteEntityClass> favmovies;
    public Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        //  public TextView text;

        public MyViewHolder(View view) {
            super(view);
            //initialize buttons and TextViews
            // title =  view.findViewById(R.id.title);
            img=  view.findViewById(R.id.img);
            //  text= view.findViewById(R.id.textviewt);
        }
    }

    //constructor
    public FavouriteAdapter(Context mContext, List<FavouriteEntityClass> favmovies) {
        this.favmovies = favmovies;
        this.mContext = mContext;
    }

    @Override
    public FavouriteAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //set layout to itemView using Layout inflater
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.popularlist, parent, false);
        return new FavouriteAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavouriteAdapter.MyViewHolder holder, final int position) {

        final FavouriteEntityClass moviesz = favmovies.get(position);
        //   holder.title.setText(journals.getTitle());
        // holder.text.setText(moviesz.getTitle());
        //Glide.with(mContext).load(moviesz.getPoster_path()).into(holder.img);
        // "http://i.imgur.com/DvpvklR.png"
       /** Picasso.get().load(moviesz.imgurl)
                .placeholder(R.drawable.spiderman)
                .error(R.drawable.errorimage)
                .fit()
                //  .resize(300, 300)
                .into(holder.img);  **/
        Glide.with(mContext)
                .load(moviesz.imgurl)
                //.centerCrop()
                .fitCenter()
                .placeholder(R.drawable.errorimage)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .crossFade()
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(mContext,""+moviesz.getId(),Toast.LENGTH_SHORT).show();

                Intent i = new Intent(mContext, FavouriteDetails.class);
                //pass data though intent using puExtra
                i.putExtra("title", moviesz.title);
                i.putExtra("overview",moviesz.overview);
                i.putExtra("date", moviesz.date);
                i.putExtra("rating", moviesz.count);
                i.putExtra("imgurl",moviesz.imgurl);
                i.putExtra("id",moviesz.movieid);
                mContext.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return favmovies.size();
    }


}
