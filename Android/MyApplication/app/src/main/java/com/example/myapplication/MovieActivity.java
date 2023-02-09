package com.example.myapplication;

import static com.example.myapplication.R.layout.activity_movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.myapplication.adapter.MovieAdapter;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.ActivityMovieBinding;
import com.example.myapplication.model.Movie;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private View view;
    Movie movie= new Movie();
    int id=0;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new infoFragment(),"INFO");
        vpAdapter.addFragment(new actorsFragment(),"GLUMCI");
        vpAdapter.addFragment(new ratingFragment(),"OCJENE");
        viewPager.setAdapter(vpAdapter);

       // binding = DataBindingUtil.setContentView(this, activity_movie);
        Intent intent= getIntent();
         id =intent.getIntExtra("int_value",0);
        Toast.makeText(this,"asd-"+id,Toast.LENGTH_SHORT).show();
        //loadMovie((long) id);
        //binding.setMovie(movie);
    }

   /* private void loadMovie(Long id) {
        id++;

        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);
        movieApi.getMovieById(id)
                .enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        movie = response.body();
                        //binding.setMovie(response.body());
                        System.out.println(response.body());
                        System.out.println(movie.getTitle().toString());
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {
                        Log.e("ERROR", String.valueOf(t));
                    }
                });

      //  return movie;
    }*/

    public Long getId(){
        return Long.valueOf(id);
    }

}