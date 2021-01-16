package com.pam.a18112556_aplikasimoviedb_fitursqllitemenufavorit.ui.main;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "movie.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table favorite(title string, desc1 string, tahun string, rate string, gambar string";
        Log.d("Data","onCreate:"+sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }

    Cursor readAllData(){
        String query = "SELECT * FROM favorite";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;

    }
}
