package com.example.coursework2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchforMovie extends AppCompatActivity {

    EditText txtOfSearch;
    Button searchMovie;
    DataBaseHelper db_search;
    ArrayList<String> titleOfM, yearOfM, directorOfM, actorsOfM , ratingOfM, reviewOfM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchfor_movie);


        txtOfSearch = findViewById(R.id.movie_search);
        searchMovie = findViewById(R.id.btn_search_movie);

        db_search = new DataBaseHelper(SearchforMovie.this);
        titleOfM = new ArrayList<>();
        yearOfM = new ArrayList<>();
        directorOfM = new ArrayList<>();
        actorsOfM = new ArrayList<>();
        ratingOfM = new ArrayList<>();
        reviewOfM= new ArrayList<>();

        DatastoreRecord();

        searchMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String word =   txtOfSearch.getText().toString().toLowerCase();

                StringBuffer buffer = new StringBuffer();



                for(int i=0; i<titleOfM.size(); i++){
                    titleOfM.set(i, titleOfM.get(i).toLowerCase());
                }

                if(titleOfM.contains(word)){
                    int index = titleOfM.indexOf(word);
                    String details = "Title : "+titleOfM.get(index)+"  Year : "+yearOfM.get(index)+"  Director : "+directorOfM.get(index)+"  Actors : "+actorsOfM.get(index)+"  Rating : "+ratingOfM.get(index)+"  Review : "+reviewOfM.get(index)+"\n\n";
                    buffer.append(details);

                }

                if(directorOfM.contains(word)){
                    int index = directorOfM.indexOf(word);
                    String details = "Title : "+titleOfM.get(index)+"  Year : "+yearOfM.get(index)+"  Director : "+directorOfM.get(index)+"  Actors : "+actorsOfM.get(index)+"  Rating : "+ratingOfM.get(index)+"  Review : "+reviewOfM.get(index)+"\n\n";

                    buffer.append(details);

                }
                if(actorsOfM.contains(word)){
                    int index = actorsOfM.indexOf(word);
                    String details = "Title : "+titleOfM.get(index)+"  Year : "+yearOfM.get(index)+"  Director : "+directorOfM.get(index)+"  Actors : "+actorsOfM.get(index)+"  Rating : "+ratingOfM.get(index)+"  Review : "+reviewOfM.get(index)+"\n\n";

                    buffer.append(details);

                }




                AlertDialog.Builder builder = new AlertDialog.Builder(SearchforMovie.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
    private void DatastoreRecord() {
        Cursor cursor = db_search.searchDataRecord();
        if(cursor.getCount()== 0){
            Toast.makeText(this,"NO Data",Toast.LENGTH_SHORT).show();

        } else{
            while (cursor.moveToNext()){
                titleOfM.add(cursor.getString(1));
                yearOfM.add(cursor.getString(2));
                directorOfM.add(cursor.getString(3));
                actorsOfM.add(cursor.getString(4));
                ratingOfM.add(cursor.getString(5));
                reviewOfM.add(cursor.getString(6));
            }
        }
    }
}