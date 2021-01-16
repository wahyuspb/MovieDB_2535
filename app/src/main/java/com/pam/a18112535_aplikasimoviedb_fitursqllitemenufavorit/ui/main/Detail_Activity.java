package com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.MainActivity;
import com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.R;

public class Detail_Activity extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbcenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_);

        final TextView title = (TextView) findViewById(R.id.txtTitle);
        final TextView desc = (TextView) findViewById(R.id.textOverview);
        final TextView year = (TextView) findViewById(R.id.txtYear);
        final TextView vote = (TextView) findViewById(R.id.txtVote);
        final ImageView imageView = (ImageView) findViewById(R.id.imgPoster);
        Button btnfavorite = (Button) findViewById(R.id.btnFav);

        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));
        year.setText(getIntent().getStringExtra("year"));
        vote.setText(getIntent().getStringExtra("rating"));


        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w200/"+getIntent().getStringExtra("gambar"))
                .into(imageView);

        btnfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("insert into favorite(title,desc1,tahun,rate,gambar) values " +
                        "('"+title.getText().toString()+"',)" +
                        "('"+desc.getText().toString()+"',)" +
                        "('"+year.getText().toString()+"',)" +
                        "('"+vote.getText().toString()+"',)" +
                        "('"+imageView.toString()+"')");
                Log.d("Berhasil","Berhasil");

            }
        });

    }
}