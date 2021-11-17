package org.dheeraj.model;

public class Movie {
    private Integer movieId;
    private String movieName;
    private String movieDesc;

    public Movie(){

    }

    public Movie(Integer movieId, String movieName, String movieDesc) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
    }
    public Integer getMovieId() {
        return movieId;
    }
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
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

    
}
