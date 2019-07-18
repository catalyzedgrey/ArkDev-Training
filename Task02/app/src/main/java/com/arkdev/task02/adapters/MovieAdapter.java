package com.arkdev.task02.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arkdev.task02.R;
import com.arkdev.task02.interfaces.OnEntryClickListener;
import com.arkdev.task02.itemviews.MovieItemView;
import com.arkdev.task02.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieItemView> {

    List<Movie> movieList;
    private OnEntryClickListener mOnEntryClickListener;


    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_movie, viewGroup, false);
        return new MovieItemView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieItemView holder, int i) {

        holder.BindMovie(movieList.get(i));
    }
    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
    }
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}