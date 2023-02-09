package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.MovieActors;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorHolder>{

    private Context mContext;
    private List<MovieActors> actors;
    public ActorAdapter(List<MovieActors> actors) { this.actors=actors;}

    @NonNull
    @Override
    public ActorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design, parent,false);
        return new ActorHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ActorHolder holder, int position) {
        MovieActors actor = actors.get(position);
        holder.name.setText(actor.getName());
        holder.lastName.setText(actor.getLastName());
        holder.info.setText(actor.getInfo());
        holder.dateOfBirth.setText(actor.getDateOfBirth());
        holder.nationality.setText(actor.getNationality());
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }
}
