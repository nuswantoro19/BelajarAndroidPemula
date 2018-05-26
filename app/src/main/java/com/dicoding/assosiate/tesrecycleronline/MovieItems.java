package com.dicoding.assosiate.tesrecycleronline;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MovieItems {
    private int id;
    private String title;
    private String rating;
    private String release;
    private String poster_path;
    private String description;
    private String original_title;
    public MovieItems(JSONObject object){
        try {
            int id=object.getInt("id");
            String title=object.getString("title");
            double avg_rating=object.getDouble("vote_average");
            String original_title=object.getString("original_title");
            String release=object.getString("release_date");
            String poster_path=object.getString("poster_path");
            String description=object.getString("overview");
            String rating=new DecimalFormat("##.##").format(avg_rating);
            this.id=id;
            this.title=title;
            this.rating=rating;
            this.release=release;
            this.poster_path=poster_path;
            this.description=description;
            this.original_title=original_title;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
}
