package com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ui.main;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.MovieAdapter1;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.R;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    private ArrayList<String> listMovie;
    private RecyclerView rvMovie;
    protected Cursor cursor;
    DatabaseHelper dbcenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_playing, container, false);

    }
}