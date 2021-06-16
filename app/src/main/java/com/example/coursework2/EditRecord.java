package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditRecord extends AppCompatActivity {

    DataBaseHelper db_movie;
    ArrayList<String> movieListRecord;
    ArrayAdapter adapterToEdit;
    ListView movieList_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_record);

        db_movie=new DataBaseHelper(this);

        movieListRecord = new ArrayList<>();
        movieList_v=findViewById(R.id.listRecord_M);
        editdata();

        movieList_v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textObj = movieList_v.getItemAtPosition(position).toString();
                Intent intent_mv = new Intent(getBaseContext(), MovieEdit.class);
                intent_mv.putExtra("title", textObj);
                startActivity(intent_mv);
            }
        });
    }
    private void editdata() {
        Cursor cur = db_movie.editRecordData();

        if (cur.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cur.moveToNext()) {
                movieListRecord.add(cur.getString(0));
            }

            adapterToEdit = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movieListRecord);
            movieList_v.setAdapter(adapterToEdit);
        }
    }
}