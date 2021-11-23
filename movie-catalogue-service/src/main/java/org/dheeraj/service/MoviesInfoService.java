package org.dheeraj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.dheeraj.model.Movie;
import org.dheeraj.model.Rating;
import org.dheeraj.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MoviesInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackUserMovieRatings",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            },
            threadPoolKey = "movieInfoThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public UserRatings getUserRatings(Rating r) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movie/getMovieInfo/" + r.getMovieId(), Movie.class);
        return new UserRatings(movie.getOriginal_title(), movie.getOverview(), r.getRating());
    }

    public UserRatings getFallbackUserMovieRatings(Rating r) {
        return new UserRatings("Not found", "Not found", r.getRating());
    }
}
