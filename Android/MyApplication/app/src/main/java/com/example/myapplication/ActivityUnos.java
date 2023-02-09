package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.model.MovieComments;
import com.example.myapplication.model.MovieRating;
import com.example.myapplication.retrofit.MovieApi;
import com.example.myapplication.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityUnos extends AppCompatActivity {
    Long id2 ;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos);
        Intent intent= getIntent();
       // int id =intent.getIntExtra("val",0);

        Bundle extras = intent.getExtras();
        id2 = extras.getLong("val");
        initializeComponents(id2);

        System.out.print(id2);

    }

    private void initializeComponents(Long id) {
        TextInputEditText inputKomentar = findViewById(R.id.form_textFieldKomentar);
        TextInputEditText inputocjena = findViewById(R.id.form_textFieldOcjena);

        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        MovieApi movieApi = retrofitService.getRetrofit().create(MovieApi.class);

        buttonSave.setOnClickListener(view -> {
            String komentar = String.valueOf(inputKomentar.getText());
            String ocjena = String.valueOf(inputocjena.getText());

            MovieComments movieComments = new MovieComments();
            movieComments.setRating(ocjena);
            movieComments.setKomentar(komentar);


            movieApi.rateMovie(id,movieComments)
                    .enqueue(new Callback<MovieComments>() {
                        @Override
                        public void onResponse(Call<MovieComments> call, Response<MovieComments> response) {
                            System.out.println(response.body());
                            intent = new Intent(view.getContext(),infoFragment.class);
                            intent.putExtra("val",id);
                            startActivity(intent);
                            Toast.makeText(ActivityUnos.this, "Save successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<MovieComments> call, Throwable t) {
                            Toast.makeText(ActivityUnos.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(ActivityUnos.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });
    }
}