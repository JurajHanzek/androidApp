package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.MovieComments;

import java.util.List;

public class ComAdapter  extends RecyclerView.Adapter<ComHolder> {

    private Context mContext;
    private List<MovieComments> comments;
    public ComAdapter(List<MovieComments> comm) { this.comments=comm;}

    @NonNull
    @Override
    public ComHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_comment_design, parent,false);
        return new ComHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ComHolder holder, int position) {
        MovieComments comm = comments.get(position);
        holder.komentar.setText(comm.getKomentar());
        holder.rating.setText(comm.getRating());
        //holder.userName.setText(comm.getUserName());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
