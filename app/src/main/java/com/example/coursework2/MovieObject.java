package com.example.coursework2;

public class MovieObject {
    private int ID;
    private String Title;
    private int Year;
    private String DirectorName;
    private String ActorNames;
    private int Rating;
    private String Review;

    public MovieObject(int id,String title, int year, String directorName, String actorNames, int rating, String review) {
        ID=id;
        Title = title;
        Year = year;
        DirectorName = directorName;
        ActorNames = actorNames;
        Rating = rating;
        Review = review;
    }
    public MovieObject(){

    }

    @Override
    public String toString() {
        return "MovieObject{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Year=" + Year +
                ", DirectorName='" + DirectorName + '\'' +
                ", ActorNames='" + ActorNames + '\'' +
                ", Rating=" + Rating +
                ", Review='" + Review + '\'' +
                '}';
    }

    public int getID(){
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public int getYear() {
        return Year;
    }

    public String getDirectorName() {
        return DirectorName;
    }

    public String getActorNames() {
        return ActorNames;
    }

    public int getRating() {
        return Rating;
    }

    public String getReview() {
        return Review;
    }
}
