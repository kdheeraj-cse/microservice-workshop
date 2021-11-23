package org.dheeraj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.dheeraj.model.Rating;
import org.dheeraj.model.UserMovieRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingDataService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRatingsByUserID")
    public ResponseEntity<UserMovieRatings> getRatingsByUserID(Integer userId) {
        return restTemplate.getForEntity("http://rating-data-service/ratings/getRatings/" + userId, UserMovieRatings.class);
    }

    public ResponseEntity<UserMovieRatings> getFallbackRatingsByUserID(Integer userId) {
        UserMovieRatings ratings = new UserMovieRatings();
        ratings.setUserMovieRatings(
                List.of(
                        new Rating(0,0,0,"")
                )

        );
        return ResponseEntity.ok(ratings);
    }
}
