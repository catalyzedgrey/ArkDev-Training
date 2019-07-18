package com.arkdev.task02.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arkdev.task02.R;
import com.arkdev.task02.adapters.MovieAdapter;
import com.arkdev.task02.models.Movie;

import java.util.ArrayList;
import java.util.List;

import network.Controller;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
        //PrepareMovieData();
    }

    private void InitViews() {
        recyclerView = findViewById(R.id.recycler_view);
        MovieAdapter adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

        Controller controller = new Controller();
        controller.start(adapter);

    }

}
