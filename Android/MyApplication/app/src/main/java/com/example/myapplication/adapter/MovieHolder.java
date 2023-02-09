package com.example.myapplication.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MovieActivity;
import com.example.myapplication.R;

public class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView name,year,rating;

    public MovieHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.movieListItem_name);
        year = itemView.findViewById(R.id.movieListItem_releaseYear);
        rating = itemView.findViewById(R.id.movieListItem_rated);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();
       // Toast.makeText(itemView.getContext(), "position"+position,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(itemView.getContext(), MovieActivity.class);
        intent.putExtra("int_value",position);
        itemView.getContext().startActivity(intent);

    }
}
