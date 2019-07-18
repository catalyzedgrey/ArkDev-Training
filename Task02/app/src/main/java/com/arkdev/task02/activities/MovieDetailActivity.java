package com.arkdev.task02.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.arkdev.task02.R;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView imgView;
    TextView titleTV, genreTV, yearTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        InitViews();
        PopulateViews();
    }

    private void InitViews() {
        imgView = findViewById(R.id.cover_img);
        titleTV = findViewById(R.id.title_tv);
        genreTV = findViewById(R.id.genre_tv);
        yearTV = findViewById(R.id.year_tv);
    }

    private void PopulateViews()
    {
        Intent i = getIntent();
        titleTV.setText(i.getStringExtra("title"));
        genreTV.setText(i.getStringExtra("genre"));
        yearTV.setText(i.getStringExtra("year"));
       imgView.setImageResource(i.getIntExtra("img", 0));

    }
}
