package com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ui.main;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
        public static final String BASE_URL = "https://api.themoviedb.org/";

        public static Retrofit getRetrofitInstance(){
            if(retrofit==null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }

            return retrofit;
    }
}
