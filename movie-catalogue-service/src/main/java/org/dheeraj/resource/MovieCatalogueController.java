package org.dheeraj.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.dheeraj.model.Movie;
import org.dheeraj.model.MovieCatalogue;
import org.dheeraj.model.UserMovieRatings;
import org.dheeraj.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieCatalogue")
public class MovieCatalogueController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/moviesRatingByUserID/{userId}")
    public ResponseEntity<MovieCatalogue> getMoviesRatingByUserID(@PathVariable("userId") Integer userId) {
        MovieCatalogue movieCatalogue = new MovieCatalogue();
        ResponseEntity<UserMovieRatings> ratingEntity = restTemplate.getForEntity("http://rating-data-service/ratings/getRatings/" + userId, UserMovieRatings.class);

        UserMovieRatings ratings = ratingEntity.getBody();

        List<UserRatings> userRatings = ratings.getUserMovieRatings().stream().map(
                r -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movie/getMovieInfo/" + r.getMovieId(), Movie.class);
                    return new UserRatings(movie.getMovieName(), movie.getMovieDesc(), r.getRating());
                }
        ).collect(Collectors.toList());
        movieCatalogue.setUserRatings(userRatings);
        return ResponseEntity.ok().body(movieCatalogue);
    }
}
