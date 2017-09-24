package com.xiangyao.train.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiangyao.train.bean.Movie;

import xiangyao.yizhilu.com.studyjourny.R;

/**
 * Created by xiangyao on 2017/9/24.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViweHolder> {
    private Movie movie;
    private Context context;

    public MovieAdapter(Movie movie, Context context) {
        this.movie = movie;
        this.context = context;
    }

    @Override
    public ViweHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViweHolder(LayoutInflater.from(context).inflate(R.layout.lisview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViweHolder holder, int position) {
        Glide.with(context)
                .load(movie.getSubjects().get(position).getImages().getLarge())
                .placeholder(R.drawable.ic_launcher_background)
                .crossFade()
                .into(holder.simpleDraweeView);
        holder.movieName.setText(movie.getSubjects().get(position).getTitle());
        holder.diractor.setText(movie.getSubjects().get(position).getDirectors().get(0).getName());
        holder.showtime.setText(movie.getSubjects().get(position).getYear());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return movie.getSubjects().size();
    }


    class ViweHolder extends RecyclerView.ViewHolder {
        TextView movieName, diractor, showtime;
        ImageView simpleDraweeView;

        public ViweHolder(View view) {
            super(view);
            movieName = view.findViewById(R.id.movie_name);
            diractor = view.findViewById(R.id.movie_dirctor);
            showtime = view.findViewById(R.id.showtime);
            simpleDraweeView = view.findViewById(R.id.moview_image);
        }
    }
}
