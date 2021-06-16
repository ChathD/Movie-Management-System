package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button SaveDetails = (Button) findViewById(R.id.Save_Button);
        EditText YearOfMovie = (EditText) findViewById(R.id.EnterMovieYear);
        EditText RatingOfMovie = (EditText) findViewById(R.id.EnterRating);
        EditText TitleOfMovie = (EditText) findViewById(R.id.EnterMovieName);
        EditText DirectorOfMovie = (EditText) findViewById(R.id.EnterDirectorName);
        EditText ActorsOfMovie = (EditText) findViewById(R.id.EnterActorName);
        EditText ReviewOfMovie = (EditText) findViewById(R.id.EnterReview);


        SaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean forYear = false;
                boolean forRating = false;
                boolean forTitle;
                boolean forDirector;
                boolean forActors;
                boolean forReview;

                String theTitleAsString = "";
                String theDirectorAsString = "";
                String theActorsAsString = "";
                String theReviewAsString = "";

                int theYear = 0;
                int theRating = 0;

                String theYearAsString = YearOfMovie.getText().toString();
                try {
                    theYear = Integer.parseInt(theYearAsString);
                    if (theYear < 1895) {

                        YearOfMovie.requestFocus();
                        YearOfMovie.setError("Enter an Integer above 1895!");
                    } else {

                        forYear = true;
                    }


                } catch (NumberFormatException e) {
                    YearOfMovie.requestFocus();
                    YearOfMovie.setError("Enter an Integer!");
                }
                String theRatingAsString = RatingOfMovie.getText().toString();
                try {
                    theRating = Integer.parseInt(theRatingAsString);
                    if (theRating > 11 || theRating < 0) {

                        RatingOfMovie.requestFocus();
                        RatingOfMovie.setError("Enter an Integer between 1 and 10!");
                    } else {
                        forRating = true;
                    }
                } catch (NumberFormatException e) {
                    RatingOfMovie.requestFocus();
                    RatingOfMovie.setError("Enter an Integer!");
                }
                forTitle=validation(theTitleAsString, TitleOfMovie);
                forDirector=validation(theDirectorAsString, DirectorOfMovie);
                forActors=validation(theActorsAsString, ActorsOfMovie);
                forReview=validation(theReviewAsString, ReviewOfMovie);

                if (forYear && forRating && forTitle && forDirector && forActors && forReview) {
                    MovieObject movieObject;
                    try {
                        movieObject = new MovieObject(-1, TitleOfMovie.getText().toString(), theYear, DirectorOfMovie.getText().toString(), ActorsOfMovie.getText().toString(), theRating, ReviewOfMovie.getText().toString());
                        Toast.makeText(RegisterActivity.this, movieObject.toString(), Toast.LENGTH_SHORT).show();
                        DataBaseHelper dataBaseHelper = new DataBaseHelper(RegisterActivity.this);
                        boolean b = dataBaseHelper.addMovie(movieObject);
                        Toast.makeText(RegisterActivity.this, "Success = " + b, Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(RegisterActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });


    }

    public boolean validation(String a, EditText e) {

        a = e.getText().toString();
        if (a.length() == 0) {
            e.requestFocus();
            e.setError("FIELD CANNOT BE EMPTY");
            return false;


        } else if (!a.matches("[a-zA-Z, ]+")) {
            e.requestFocus();
            e.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;

        } else {
           return true;
        }


    }


    }
