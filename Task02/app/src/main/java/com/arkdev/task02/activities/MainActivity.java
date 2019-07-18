package com.arkdev.task02.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.arkdev.task02.R;
import com.arkdev.task02.adapters.MovieAdapter;
import com.arkdev.task02.models.Book;
import com.arkdev.task02.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
        PrepareMovieData();
    }

    private void InitViews() {
        recyclerView = findViewById(R.id.recycler_view);
        MovieAdapter adapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }


    private void PrepareMovieData() {

        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.ic_launcher_foreground);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.ic_launcher_foreground);
        movieList.add(movie);

        movie = new Movie("Star Wars", "Action & Adventure", "2015", R.drawable.ic_launcher_foreground);
        movieList.add(movie);

        movie = new Movie("The Martian", "Action & Adventure", "2015", R.drawable.ic_launcher_foreground);
        movieList.add(movie);
    }
}
