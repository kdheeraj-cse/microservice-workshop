package org.dheeraj.model;

public class Rating {
    
    private Integer ratingID;
    private Integer userId;
    private Integer movieId;
    private String rating;

    public Rating() {
    }

    public Rating(Integer ratingID, Integer userId, Integer movieId, String rating) {
        this.ratingID = ratingID;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }
    public Integer getRatingID() {
        return ratingID;
    }
    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getMovieId() {
        return movieId;
    }
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    

}
