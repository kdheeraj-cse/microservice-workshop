package org.dheeraj.model;

import java.util.List;

public class MovieCatalogue {
    private List<UserRatings> userRatings;

    public MovieCatalogue(){

    }

    public List<UserRatings> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<UserRatings> userRatings) {
        this.userRatings = userRatings;
    }
}
