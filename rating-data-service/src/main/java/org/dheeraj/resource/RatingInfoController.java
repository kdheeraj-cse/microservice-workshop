package org.dheeraj.resource;

import java.util.stream.Collectors;

import org.dheeraj.datasource.RatingCollection;
import org.dheeraj.exception.NoRatingFoundException;
import org.dheeraj.exception.RatingServiceResponse;
import org.dheeraj.models.UserMovieRatings;
import org.dheeraj.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingInfoController {
    
    @Autowired
    private RatingService ratingService;

    @GetMapping("/getRatings/{userId}")
    public ResponseEntity<RatingServiceResponse<UserMovieRatings>> getUserRatings(@PathVariable("userId") Integer userId) throws NoRatingFoundException {
        RatingServiceResponse<UserMovieRatings> response = new RatingServiceResponse<>();
        UserMovieRatings ratings = ratingService.getUserRatings(userId);
        response.setHttpStatus(HttpStatus.OK);
        response.setResponse(ratings);
        response.setMessage("success");
        return ResponseEntity.ok().body(response);
    }
}
