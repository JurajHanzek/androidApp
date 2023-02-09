package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.model.Movie;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.movieList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMovies();
    }
        private void loadMovies(){
            RetrofitService retrofitService = new RetrofitService();
            MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
            movieApi.getAllMovies()
                    .enqueue(new Callback<List<Movie>>() {

                        @Override
                        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                            populateListView(response.body());
                        }

                        @Override
                        public void onFailure(Call<List<Movie>> call, Throwable t) {
                            Log.e("ERROR", String.valueOf(t));
                            Toast.makeText(MovieListActivity.this, "Failed to load Movies", Toast.LENGTH_SHORT).show();
                        }
                    });

        }


    private void populateListView(List<Movie> movieList) {
        MovieAdapter movieAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(movieAdapter);
    }
}