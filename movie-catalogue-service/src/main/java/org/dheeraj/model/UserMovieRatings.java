package org.dheeraj.model;

import java.util.List;

public class UserMovieRatings {
    List<Rating> userMovieRatings;

    public UserMovieRatings() {
    }

    public UserMovieRatings(List<Rating> userMovieRatings) {
        this.userMovieRatings = userMovieRatings;
    }

    public List<Rating> getUserMovieRatings() {
        return userMovieRatings;
    }

    public void setUserMovieRatings(List<Rating> userMovieRatings) {
        this.userMovieRatings = userMovieRatings;
    }
}
