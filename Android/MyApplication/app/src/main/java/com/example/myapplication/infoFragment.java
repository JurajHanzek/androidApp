package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.databinding.FragmentInfoBinding;
import com.example.myapplication.model.Movie;
import com.example.myapplication.model.MovieInfo;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;

import java.io.File;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class infoFragment extends Fragment {

    FragmentInfoBinding binding;
    MovieInfo movie= new MovieInfo();
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageView ImgView = (ImageView) container.findViewById(R.id.idIVImage);
        return inflater.inflate(R.layout.fragment_info, container, false);
    }
    public static Drawable getImage(Context context, String name) {
        return context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", context.getPackageName()));
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         imageView = (ImageView) getView().findViewById(R.id.idIVImage);


        MovieActivity movieActivity = (MovieActivity) getActivity();
        Long id = movieActivity.getId();
        System.out.println(id);
        binding = FragmentInfoBinding.bind(view);
        id++;
        loadMovie(id);
        imageView.setImageDrawable(getImage(requireContext(), "a"+id.toString()));
        super.onViewCreated(view, savedInstanceState);
    }

    private void loadMovie(Long id) {


        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
        movieApi.getMovieById(id)
                .enqueue(new Callback<MovieInfo>() {
                    @Override
                    public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                        movie = response.body();
                        binding.setMovie(response.body());
                        System.out.println(response.body());
                        System.out.println(movie.getTitle().toString());
                    }
                    @Override
                    public void onFailure(Call<MovieInfo> call, Throwable t) {
                        Log.e("ERROR", String.valueOf(t));
                    }
                });

    }
}