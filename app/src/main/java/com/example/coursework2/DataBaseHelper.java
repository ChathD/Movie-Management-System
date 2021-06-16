package com.example.coursework2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String MOVIE_TABLE = "MOVIE_TABLE";
    public static final String COLUMN_MOVIE_TITLE = "MOVIE_TITLE";
    public static final String COLUMN_MOVIE_YEAR = "MOVIE_YEAR";
    public static final String COLUMN_MOVIE_DIRECTOR = "MOVIE_DIRECTOR";
    public static final String COLUMN_ACTOR_NAMES = "ACTOR_NAMES";
    public static final String COLUMN_MOVIE_RATING = "MOVIE_RATING";
    public static final String COLUMN_MOVIE_REVIEW = "MOVIE_REVIEW";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "movie.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createMovieTable= "CREATE TABLE " + MOVIE_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_MOVIE_TITLE + " TEXT, " + COLUMN_MOVIE_YEAR + " INT, " + COLUMN_MOVIE_DIRECTOR + " TEXT, " + COLUMN_ACTOR_NAMES + " TEXT, " + COLUMN_MOVIE_RATING + " INT, " + COLUMN_MOVIE_REVIEW + " TEXT)";
        db.execSQL(createMovieTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addMovie(MovieObject movieObject){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_MOVIE_TITLE, movieObject.getTitle());
        cv.put(COLUMN_MOVIE_YEAR, movieObject.getYear());
        cv.put(COLUMN_MOVIE_DIRECTOR, movieObject.getDirectorName());
        cv.put(COLUMN_ACTOR_NAMES,movieObject.getActorNames());
        cv.put(COLUMN_MOVIE_RATING,movieObject.getRating());
        cv.put(COLUMN_MOVIE_REVIEW,movieObject.getReview());
        long insert = db.insert(MOVIE_TABLE, null, cv);
        if(insert==-1){
            return false;
        }else{
            return true;
        }



    }
    public List<String> getMovieNames(){
        try {
            List<String> movieNameList = new ArrayList<>();

            String queryString = "SELECT * FROM " + MOVIE_TABLE;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(queryString, null);

            if (cursor.moveToFirst()) {
                do {
                    movieNameList.add(cursor.getString(cursor.getColumnIndex(COLUMN_MOVIE_TITLE)));
                } while (cursor.moveToNext());
                cursor.close();

            }
            return movieNameList;
        }catch(Exception e){
            return null;
        }
    }

    public Cursor editRecordData() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query_rec = "SELECT * FROM "+MOVIE_TABLE;
        Cursor cursor = database.rawQuery(query_rec, null);

        return cursor;
    }
    public Cursor searchDataRecord(){
        SQLiteDatabase db = this.getReadableDatabase();
        String SearchQueryforRecord = "Select * from "+MOVIE_TABLE;
        Cursor cursor = db.rawQuery(SearchQueryforRecord, null);

        return cursor;
    }

}
