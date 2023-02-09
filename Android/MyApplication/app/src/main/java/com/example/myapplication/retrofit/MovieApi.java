package com.example.myapplication.retrofit;

import com.example.myapplication.model.Movie;
import com.example.myapplication.model.MovieActors;
import com.example.myapplication.model.MovieComments;
import com.example.myapplication.model.MovieInfo;
import com.example.myapplication.model.MovieRating;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MovieApi {

    @GET("/movie/all")
    Call<List<Movie>> getAllMovies();

    @GET("/android/movie/{id}")
    Call<MovieInfo> getMovieById(@Path("id") Long id);

    @GET("/android/actors/{id}")
    Call<List<MovieActors>> getActorsById(@Path("id") Long id);

    @GET("/android/movie/ocjena/{id}")
    Call<MovieRating> getMovieRating(@Path("id") Long id);

    @GET("/android/movie/comments/{id}")
    Call<List<MovieComments>> getComments(@Path("id") Long id);

    @POST("/android/movie/rate/{id}")
    Call<MovieComments> rateMovie(@Path("id") Long id,@Body MovieComments movieComments);
}
