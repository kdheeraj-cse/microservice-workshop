package org.dheeraj.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.dheeraj.model.*;
import org.dheeraj.service.MoviesInfoService;
import org.dheeraj.service.RatingDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieCatalogue")
public class MovieCatalogueController {

    Logger logger = LoggerFactory.getLogger(MovieCatalogueController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RatingDataService ratingDataService;

    @Autowired
    MoviesInfoService moviesInfoService;


    @GetMapping("/moviesRatingByUserID/{userId}")
    public ResponseEntity<MovieCatalogue> getMoviesRatingByUserID(@PathVariable("userId") Integer userId) {
        logger.info("userId = {} ", userId);
        MovieCatalogue movieCatalogue = new MovieCatalogue();

        ResponseEntity<UserMovieRatings> ratingEntity = ratingDataService.getRatingsByUserID(userId);
        UserMovieRatings ratings = ratingEntity.getBody();

        List<UserRatings> userRatings = ratings.getUserMovieRatings().stream().map(
                r -> {
                    return moviesInfoService.getUserRatings(r);
                }
        ).collect(Collectors.toList());
        movieCatalogue.setUserRatings(userRatings);
        logger.info("userRatings = {}", userRatings);
        return ResponseEntity.ok().body(movieCatalogue);
    }
}
