package com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit.model.Movie;
import com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit.ui.main.DatabaseHelper;
import com.pam.a18112535_aplikasimoviedb_fitursqllitemenufavorit.ui.main.Detail_Activity;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private ArrayList<Movie> listmovie;



    public MovieAdapter(ArrayList<Movie> listmovie){
        this.listmovie = listmovie;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Movie movie = listmovie.get(position);
        holder.txtTitle.setText(movie.getTitle());
        holder.txtYear.setText(movie.getReleaseDate());
        holder.txtOverview.setText(movie.getOverview());
        holder.gambar1.setText(movie.getPosterPath());


        Glide.with(holder.itemView)
                .load("https://image.tmdb.org/t/p/w200/"+movie.getPosterPath())
                .into(holder.imgPoster);

        holder.txtVote.setText(movie.getVoteAverage().toString());
    }


    @Override
    public int getItemCount() {
        return listmovie.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtYear;
        TextView txtOverview;
        ImageView imgPoster;
        TextView txtVote;
        TextView gambar1;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtOverview = itemView.findViewById(R.id.textOverview);
            imgPoster = itemView.findViewById(R.id.imgPoster);
            txtVote = itemView.findViewById(R.id.txtVote);
            gambar1 = itemView.findViewById(R.id.gambar1);


            Button btndetail = itemView.findViewById(R.id.btnDetail);
            Button btnfavorite = itemView.findViewById(R.id.btnDetail);

            btndetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), Detail_Activity.class);
                        intent.putExtra("title", txtTitle.getText().toString());
                        intent.putExtra("desc", txtOverview.getText().toString());
                        intent.putExtra("rating", txtVote.getText().toString());
                        intent.putExtra("year", txtYear.getText().toString());
                        intent.putExtra("gambar", gambar1.getText().toString());
                        view.getContext().startActivity(intent);

                }
            });
        }
    }
}
