package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RatingsOfOut extends AppCompatActivity {

    ImageView imgV_m;
    String img_URL;
    Bitmap BitMap_Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings_of_out);

        imgV_m = findViewById(R.id.imgV_out);

        Intent int_Movie = getIntent();
        String mv_name = int_Movie.getStringExtra("name");

        new Thread(new CocktailDetailsRunnable(mv_name)).start();
    }
    class CocktailDetailsRunnable implements Runnable {
        String name_out_req;

        CocktailDetailsRunnable(String name) {
            name_out_req = name;
        }

        @Override
        public void run() {
            StringBuilder stb_out = new StringBuilder("");
            StringBuilder id_out = new StringBuilder("");
            StringBuilder title_m_out = new StringBuilder("");
            StringBuilder des_str = new StringBuilder("");

            try {
                // make the connection and receive the input stream
                URL url = new URL("https://imdb-api.com/en/API/SearchMovie/k_783f4uy0/" +
                        name_out_req.trim());
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                // read all lines in a stringbuilder
                String line;
                while ((line = bf.readLine()) != null) {
                    stb_out.append(line);
                }

                /* do the JSON parsing */
                JSONObject json = new JSONObject(stb_out.toString());
                JSONArray jsonArray = json.getJSONArray("results");

                // find the matching cocktail name entry and extract recipe
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject j_req = jsonArray.getJSONObject(i);
                    String cocktail_name = j_req.getString("title");
                    if (cocktail_name.toLowerCase().equals(name_out_req.toLowerCase())) {
                        id_out.append(j_req.getString("id"));
                        title_m_out.append(j_req.getString("title"));
                        des_str.append(j_req.getString("description"));
                        img_URL = j_req.getString("image");
                    }

                }

            } catch (MalformedURLException er) {
                er.printStackTrace();
            } catch (IOException er) {
                er.printStackTrace();
            } catch (JSONException er) {
                er.printStackTrace();
            }

            BitMap_Img = getBitmapValue();

            /* update the textview with the recipe */
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    imgV_m.setImageBitmap(BitMap_Img);

                }
            });
        }


        // retrieve a bitmap image from the URL in JSON
        Bitmap getBitmapValue() {
            Bitmap bit_code = null;
            try {
                URL url = new URL(img_URL);
                HttpURLConnection connection_URL = (HttpURLConnection) url.openConnection();
                BufferedInputStream bfstream = new BufferedInputStream(connection_URL.getInputStream());

                bit_code = BitmapFactory.decodeStream(bfstream);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }

            return bit_code;
        }
    }
}