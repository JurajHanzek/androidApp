package com.example.myapplication.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ComHolder extends RecyclerView.ViewHolder {


    TextView komentar,rating,userName;

    public ComHolder(@NonNull View itemView) {
        super(itemView);
        komentar = itemView.findViewById(R.id.commList_kom);
        rating = itemView.findViewById(R.id.commList_rat);
        //userName = itemView.findViewById(R.id.commList_user);

    }
}
