package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MovieEdit extends AppCompatActivity {
    String ChangeTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_edit);

        ChangeTitle = getIntent().getStringExtra("title");


    }
}