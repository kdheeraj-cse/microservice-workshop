package org.dheeraj.service;

import org.dheeraj.datasource.RatingCollection;
import org.dheeraj.exception.NoRatingFoundException;
import org.dheeraj.models.Rating;
import org.dheeraj.models.UserMovieRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {
    @Autowired
    private RatingCollection ratingCollection;

    public UserMovieRatings getUserRatings (Integer userId) throws NoRatingFoundException {
        List<Rating> ratings = ratingCollection.getRatingCollection().stream().filter(rating -> rating.getUserId().equals(userId)).collect(Collectors.toList());
        if(ratings.isEmpty()){
            throw new NoRatingFoundException("No ratings found for this user id "+userId);
        }
        return  new UserMovieRatings(ratings);
    }

}
