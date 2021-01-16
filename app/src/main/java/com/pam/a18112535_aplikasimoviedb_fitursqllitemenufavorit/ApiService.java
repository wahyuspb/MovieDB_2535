package com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit;

import com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("3/movie/now_playing")
    Call<MovieResponse> getPlayingMovie(@Query("api_key") String apiKey);

}
