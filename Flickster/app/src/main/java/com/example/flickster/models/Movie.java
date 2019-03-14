package com.example.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String posterPath;
    String title;
    String overView;
    String backDropPath;

    //Construstor which takes in a JSON Object and it will create a movie
    public  Movie (JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
        backDropPath = jsonObject.getString("backdrop_path");
    }

        public static List<Movie> fromJsonArray(JSONArray moviejsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int x = 0; x <moviejsonArray.length(); x++)
        {
            movies.add(new Movie(moviejsonArray.getJSONObject(x)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath ) ;
    }
    public String getBackDropPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backDropPath ) ;
    }
    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
