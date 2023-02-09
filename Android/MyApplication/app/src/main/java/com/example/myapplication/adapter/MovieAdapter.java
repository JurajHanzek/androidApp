package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    private List<Movie> movieList;

    public MovieAdapter ( List<Movie> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //ovisno o item countu tolko puta se pokrene
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_movie_item, parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.name.setText(movie.getTitle());
        holder.year.setText(movie.getReleaseyear());
        holder.rating.setText(movie.getRated());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
