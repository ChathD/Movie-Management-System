package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ratings_In extends AppCompatActivity {
    TextView textView_Rating_In;
    android.widget.EditText edt_In;
  //  ImageView imgview_Rating;

    TextView getTextView_Rating_In;
    EditText editing_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings__in);

        textView_Rating_In=findViewById(R.id.TextViewer_mv);
        edt_In=findViewById(R.id.edit_to_movie);
      //  imgview_Rating=findViewById(R.id.imgview);
        getTextView_Rating_In = findViewById(R.id.TextViewer_mv2);
        editing_view = findViewById(R.id.edit_to_movie_2);


    }
    public void getMovieNames(View view) {
        String movie_req = edt_In.getText().toString();

        new Thread(new CocktailsNamesRunnable(movie_req)).start();
    }

    public void getRecipe(View view) {
        String film_req = editing_view.getText().toString();
        Intent i = new Intent(this, RatingsOfOut.class);
        i.putExtra("name", film_req);
        startActivity(i);
    }


    class CocktailsNamesRunnable implements Runnable {
        String movie_req_str;

        CocktailsNamesRunnable(String movie_ing) {
            movie_req_str = movie_ing;
        }

        @Override
        public void run() {
            StringBuilder stb0_movie = new StringBuilder("");  // contains all json
            StringBuilder stb1_movie = new StringBuilder("");  // contains all drink names

            try {
                // make the connection and receive the input stream
                URL url = new URL("https://imdb-api.com/en/API/SearchMovie/k_783f4uy0/" +
                        movie_req_str.trim());
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                BufferedReader bf_reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                // read all lines info in a stringbuilder
                String str_line;
                while ((str_line = bf_reader.readLine()) != null) {
                    stb0_movie.append(str_line);
                }

                /* do the JSON parsing */
                JSONObject jObj = new JSONObject(stb0_movie.toString());
                JSONArray jsonArr = jObj.getJSONArray("results");

                // find the cocktail names entries and put them in stb2
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject json_drink = jsonArr.getJSONObject(i);
                    String film_req_name = json_drink.getString("title");
                    stb1_movie.append(film_req_name + "\n");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textView_Rating_In.setText(stb1_movie.toString());
                }
            });
        }
    }

}