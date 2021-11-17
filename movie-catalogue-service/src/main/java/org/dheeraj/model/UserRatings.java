package org.dheeraj.model;

public class UserRatings {
    private String movieName;
    private String movieDesc;
    private String movieRating;

    public UserRatings() {
    
    }
    
    public UserRatings(String movieName, String movieDesc, String movieRating) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.movieRating = movieRating;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieDesc() {
        return movieDesc;
    }
    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }
    public String getMovieRating() {
        return movieRating;
    }
    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }
    
    
    
}
