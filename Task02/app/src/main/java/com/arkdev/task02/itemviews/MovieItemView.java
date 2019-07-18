package com.arkdev.task02.itemviews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arkdev.task02.R;
import com.arkdev.task02.activities.MainActivity;
import com.arkdev.task02.activities.MovieDetailActivity;
import com.arkdev.task02.interfaces.OnEntryClickListener;
import com.arkdev.task02.models.Movie;

import static android.content.ContentValues.TAG;

public class MovieItemView extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imgView;
    public TextView nameTV, genreTV, yearTV;
    int imgID;
    private OnEntryClickListener mOnEntryClickListener;

    public MovieItemView(View itemView) {
        super(itemView);
        imgView = itemView.findViewById(R.id.cover_img);
        nameTV = itemView.findViewById(R.id.title_tv);
        genreTV = itemView.findViewById(R.id.genre_tv);
        yearTV = itemView.findViewById(R.id.year_tv);

        //this.mOnEntryClickListener = mOnEntryClickListener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), MovieDetailActivity.class);
        i.putExtra("title", nameTV.getText().toString());
        i.putExtra("genre", genreTV.getText().toString());
        i.putExtra("year", yearTV.getText().toString());
        i.putExtra("img", imgID);
        v.getContext().startActivity(i);
    }

    public void BindMovie(Movie movie)
    {
        nameTV.setText(movie.getTitle());
        genreTV.setText(movie.getGenre());
        yearTV.setText(movie.getYear());
        imgView.setImageResource(movie.getImgID());
        imgID = movie.getImgID();
    }

}
