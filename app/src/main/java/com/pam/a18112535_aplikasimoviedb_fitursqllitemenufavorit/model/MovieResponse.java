package com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private ArrayList<Movie> result;

    @SerializedName("total_pages")
    private int total_pages;

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int total_results;

    public ArrayList<Movie> getResult() {
        return result;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setResult(ArrayList<Movie> result) {
        this.result = result;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
