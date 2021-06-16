package com.example.coursework2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter <CustomerAdapter.MyViewHolder> {
    private Context context;
    private ArrayList ID_Movie, Title_Movie, Year_Movie, Director_Movie, Actor_Movie,Rating_Movie, Review_Movie;



    CustomerAdapter(Context context, ArrayList ID_Movie,
                    ArrayList Title_Movie,
                    ArrayList Year_Movie,
                    ArrayList Director_Movie,
                    ArrayList Actor_Movie,
                    ArrayList Rating_Movie,
                    ArrayList Review_Movie){
        this.context = context;
        this.ID_Movie = ID_Movie;
        this.Title_Movie = Title_Movie;
        this.Year_Movie = Year_Movie;
        this.Director_Movie = Director_Movie;
        this.Actor_Movie = Actor_Movie;
        this.Rating_Movie = Rating_Movie;
        this.Review_Movie = Review_Movie;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows_custom,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.txt_id.setText(String.valueOf(ID_Movie.get(position)));
        holder.txt_title.setText(String.valueOf(Title_Movie.get(position)));
        holder.txt_yr.setText(String.valueOf(Year_Movie.get(position)));
        holder.txt_director.setText(String.valueOf(Director_Movie.get(position)));
        holder.txt_actor.setText(String.valueOf(Actor_Movie.get(position)));
        holder.txt_rating.setText(String.valueOf(Rating_Movie.get(position)));
        holder.txt_review.setText(String.valueOf(Review_Movie.get(position)));


    }

    @Override
    public int getItemCount() {
        return ID_Movie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_id,txt_title, txt_yr, txt_director, txt_actor, txt_rating, txt_review;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_id= itemView.findViewById(R.id.movie_id_text);
            txt_title= itemView.findViewById(R.id.text_title);
            txt_yr= itemView.findViewById(R.id.year_text);
            txt_director= itemView.findViewById(R.id.director_text);
            txt_actor= itemView.findViewById(R.id.text_actor);
            txt_rating= itemView.findViewById(R.id.text_rating);
            txt_review= itemView.findViewById(R.id.text_review);

        }
    }
}

