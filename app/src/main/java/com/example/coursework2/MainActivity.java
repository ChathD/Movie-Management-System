package com.example.coursework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button OpenRegisterActivity;
    Button OpenDisplayActivity;
    Button OpenEditActivity;
    Button OpenSearchActivity;
    Button OpenRatingActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenRegisterActivity=(Button)findViewById(R.id.RegisterMovie_Button);
           OpenRegisterActivity.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent ActivityRegister=new Intent(getApplicationContext(),RegisterActivity.class);
                   startActivity(ActivityRegister);
               }
           });

        OpenDisplayActivity=(Button)findViewById(R.id.DisplayMovie_Button);
        OpenDisplayActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityDisplay=new Intent(getApplicationContext(),DisplayActivity.class);
                startActivity(ActivityDisplay);
            }
        });

        OpenEditActivity=(Button)findViewById(R.id.EditMovie_Button);
        OpenEditActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityEdit=new Intent(getApplicationContext(),EditRecord.class);
                startActivity(ActivityEdit);
            }
        });

        OpenSearchActivity=(Button)findViewById(R.id.Search_Button);
        OpenSearchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivitySearch=new Intent(getApplicationContext(),SearchforMovie.class);
                startActivity(ActivitySearch);
            }
        });
        OpenRatingActivity=(Button)findViewById(R.id.Rating_Button);
        OpenRatingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityRating=new Intent(getApplicationContext(),Ratings_In.class);
                startActivity(ActivityRating);
            }
        });




    }
}