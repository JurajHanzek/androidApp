package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.adapter.ActorAdapter;
import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.MovieActors;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class actorsFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_actors,container,false);
        recyclerView = view.findViewById(R.id.actorList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MovieActivity movieActivity = (MovieActivity) getActivity();
        Long id = movieActivity.getId();
        loadActors(id);
        return view;
    }


    private void loadActors(Long id){
        id++;
        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
        movieApi.getActorsById(id)
                .enqueue(new Callback<List<MovieActors>>() {

                    @Override
                    public void onResponse(Call<List<MovieActors>> call, Response<List<MovieActors>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<MovieActors>> call, Throwable t) {
                        Log.e("ERROR", String.valueOf(t));
                       // Toast.makeText(actorsFragment.this, "Failed to load Movies", Toast.LENGTH_SHORT).show();
                    }
                });

    }


    private void populateListView(List<MovieActors> actorsList) {
        ActorAdapter actorAdapter = new ActorAdapter(actorsList);
        recyclerView.setAdapter(actorAdapter);
    }
}