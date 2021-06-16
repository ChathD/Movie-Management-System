package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        ListView movie_listView = findViewById(R.id.Display_ListView);
        Button add_favourites_button = findViewById(R.id.add_favourites_button);

        DataBaseHelper dataBaseHelper=new DataBaseHelper(DisplayActivity.this);
        List<String> movieNames = dataBaseHelper.getMovieNames();
        Collections.sort(movieNames);
        ArrayAdapter<String> movieNameArrayAdapter = new ArrayAdapter<String>(DisplayActivity.this,android.R.layout.simple_list_item_1,movieNames);
        movie_listView.setAdapter(movieNameArrayAdapter);





//        add_favourites_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DataBaseHelper dataBaseHelper=new DataBaseHelper(DisplayActivity.this);
//                List<String> movieNames = dataBaseHelper.getMovieNames();
//                Collections.sort(movieNames);
//                ArrayAdapter<String> movieNameArrayAdapter = new ArrayAdapter<String>(DisplayActivity.this,android.R.layout.simple_list_item_1,movieNames);
//                movie_listView.setAdapter(movieNameArrayAdapter);
//
//
//               // Toast.makeText(DisplayActivity.this, Arrays.toString(movieNames.toArray()),Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

}