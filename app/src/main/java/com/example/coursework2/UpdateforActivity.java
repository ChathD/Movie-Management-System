package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateforActivity extends AppCompatActivity {

    EditText title_updateM, year_updateM, director_updateM, artist_updateM,rating_updateM,review_updateM;
    Button update_for_button;

    String MovieOfId, MovieOftitle, MovieOfyear, MovieOfDirector, MovieOfActor, MovieOfRating, MovieOfReview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatefor);

        title_updateM = findViewById(R.id.text_v1);
        year_updateM = findViewById(R.id.text_v2);
        director_updateM = findViewById(R.id.text_v3);
        artist_updateM = findViewById(R.id.text_v4);
        rating_updateM = findViewById(R.id.text_v5);
        review_updateM = findViewById(R.id.text_v6);
        update_for_button = findViewById(R.id.update_btn);
        update_for_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        SettingIntentValues();
    }
    void SettingIntentValues(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("year")
                && getIntent().hasExtra("director") && getIntent().hasExtra("actor") && getIntent().hasExtra("rating")
                && getIntent().hasExtra("review")){

            //getting a data from intent
            MovieOfId=getIntent().getStringExtra("id");
            MovieOftitle=getIntent().getStringExtra("title");
            MovieOfyear=getIntent().getStringExtra("year");
            MovieOfDirector=getIntent().getStringExtra("director");
            MovieOfActor=getIntent().getStringExtra("actor");
            MovieOfRating=getIntent().getStringExtra("rating");
            MovieOfReview=getIntent().getStringExtra("review");

            //setting intent data
            title_updateM.setText(MovieOfId);
            year_updateM.setText(MovieOfyear);
            director_updateM.setText(MovieOfDirector);
            artist_updateM.setText(MovieOfActor);
            rating_updateM.setText(MovieOfRating);
            review_updateM.setText(MovieOfReview);


        }else {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }
}