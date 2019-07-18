package com.arkdev.task02.itemviews;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkdev.task02.R;
import com.arkdev.task02.activities.MovieDetailActivity;
import com.arkdev.task02.models.Movie;
import com.arkdev.task02.utils.Constants;
import com.bumptech.glide.Glide;

public class MovieItemView extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imgView;
    public TextView nameTV, yearTV;
    private View itemView;
    String imgURL, overview;
    public MovieItemView(View itemView) {
        super(itemView);
        this.itemView = itemView;
        imgView = itemView.findViewById(R.id.cover_img);
        nameTV = itemView.findViewById(R.id.title_tv);
        yearTV = itemView.findViewById(R.id.year_tv);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), MovieDetailActivity.class);
        i.putExtra("title", nameTV.getText().toString());
        i.putExtra("year", yearTV.getText().toString());
        i.putExtra("img", imgURL);
        i.putExtra("overview", overview);
        v.getContext().startActivity(i);
    }

    public void BindMovie(Movie movie) {
        nameTV.setText(movie.getTitle());
        yearTV.setText(movie.getYear());
        imgURL = Constants.IMG_URL+movie.getImgPath();
        Glide.with(itemView).load(imgURL ).into(imgView);
        overview = movie.getOverview();
    }

}
