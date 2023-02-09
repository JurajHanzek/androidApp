package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.adapter.ActorAdapter;
import com.example.myapplication.adapter.ComAdapter;
import com.example.myapplication.databinding.FragmentInfoBinding;
import com.example.myapplication.databinding.FragmentRatingBinding;
import com.example.myapplication.model.MovieActors;
import com.example.myapplication.model.MovieComments;
import com.example.myapplication.model.MovieInfo;
import com.example.myapplication.model.MovieRating;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ratingFragment extends Fragment {
    Intent intent;
    Long id;
    FragmentRatingBinding binding;
    MovieRating movieRating = new MovieRating();
    private RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating,container,false);
        recyclerView = view.findViewById(R.id.commList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MovieActivity movieActivity = (MovieActivity) getActivity();
         id = movieActivity.getId();
        id++;
        loadComments(id);
        //return inflater.inflate(R.layout.fragment_rating, container, false);

         floatingActionButton =(FloatingActionButton) view.findViewById(R.id.commList_fab);
         floatingActionButton.setOnClickListener(view2 ->{
              intent = new Intent(view.getContext(),ActivityUnos.class);
             intent.putExtra("val",id);
            startActivity(intent);
         });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {





        MovieActivity movieActivity = (MovieActivity) getActivity();
        Long id = movieActivity.getId();
        binding = FragmentRatingBinding.bind(view);
        id++;
        loadMovieRating(id);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        //id++;
        loadComments(id);
        super.onResume();
    }

    private void loadMovieRating(Long id) {
        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
        movieApi.getMovieRating(id)
                .enqueue(new Callback<MovieRating>() {
                    @Override
                    public void onResponse(Call<MovieRating> call, Response<MovieRating> response) {
                        movieRating = response.body();
                        binding.setRating(response.body());
                    }
                    @Override
                    public void onFailure(Call<MovieRating> call, Throwable t) {
                        Log.e("ERROR", String.valueOf(t));
                    }
                });

    }

    private void loadComments(Long id){
        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
        movieApi.getComments(id)
                .enqueue(new Callback<List<MovieComments>>() {

                    @Override
                    public void onResponse(Call<List<MovieComments>> call, Response<List<MovieComments>> response) {
                        populateListView(response.body());

                    }

                    @Override
                    public void onFailure(Call<List<MovieComments>> call, Throwable t) {
                        Log.e("ERROR", String.valueOf(t));
                        // Toast.makeText(actorsFragment.this, "Failed to load Movies", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void populateListView(List<MovieComments> comments) {
        ComAdapter comAdapter = new ComAdapter(comments);
        recyclerView.setAdapter(comAdapter);
    }

}