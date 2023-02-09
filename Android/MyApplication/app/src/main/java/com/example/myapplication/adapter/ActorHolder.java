package com.example.myapplication.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ActorHolder extends RecyclerView.ViewHolder {

    TextView name,lastName,dateOfBirth,info,nationality;


    public ActorHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.actorListItem_name);
        lastName = itemView.findViewById(R.id.actorListItem_lastName);
        dateOfBirth = itemView.findViewById(R.id.actorListItem_dateOfBirth);
        info = itemView.findViewById(R.id.actorListItem_info);
        nationality = itemView.findViewById(R.id.actorListItem_nationality);
    }
}
