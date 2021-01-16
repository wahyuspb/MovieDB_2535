package com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ApiService;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.model.Movie;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.MovieAdapter;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.R;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.model.MovieResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlayingFragment extends Fragment {

    private ArrayList<Movie> listMovie;
    private RecyclerView rvMovie;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_playing, container, false);

        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        Call<MovieResponse> call = service.getPlayingMovie("0cc2b426e92f33f1839bee0ee4594e58");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                listMovie = response.body().getResult();

                MovieAdapter movieAdapter = new MovieAdapter(listMovie);
                rvMovie.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return view;
    }
}


