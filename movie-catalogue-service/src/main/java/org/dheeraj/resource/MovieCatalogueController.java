package org.dheeraj.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dheeraj.model.Movie;
import org.dheeraj.model.Rating;
import org.dheeraj.model.UserRatings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieCatalogue")
public class MovieCatalogueController {
    
    @GetMapping("/moviesRatingByUserID/{userId}")
    public ResponseEntity<List<UserRatings>> getMoviesRatingByUserID(@PathVariable("userId") Integer userId){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rating[]> ratingEntity = restTemplate.getForEntity("http://localhost:9002/ratings/getRatings/"+userId, Rating[].class);

        List<UserRatings> userRatings = new ArrayList<>();
        List<Rating> ratings = Arrays.asList(ratingEntity.getBody());

        ratings.forEach(
            r -> {
                Movie movie = restTemplate.getForObject("http://localhost:9001/movie/getMovieInfo/"+r.getMovieId(), Movie.class);
                userRatings.add(new UserRatings(movie.getMovieName(), movie.getMovieDesc(), r.getRating()));
            }
        );
        return ResponseEntity.ok().body(userRatings);
    }

}
