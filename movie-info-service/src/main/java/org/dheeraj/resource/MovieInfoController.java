package org.dheeraj.resource;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.netflix.discovery.converters.Auto;
import org.dheeraj.dataSource.MovieCollection;
import org.dheeraj.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {
    
    @Autowired
    MovieCollection movieCollection;

    @Autowired
    RestTemplate restTemplate;

    @Value("${api_key}")
    private String apiKey;

    @GetMapping("/getMovieInfo/{movieId}")
    public ResponseEntity<Movie> getMovieInformation(@PathVariable("movieId") Integer movieId) throws InterruptedException{

        Random r = new Random();
        int low = 1;
        int high = 1500;
        Integer randomSleepTime = r.nextInt(high-low) + low;

        System.out.println("randomSleepTime "+ randomSleepTime );
        Thread.sleep(randomSleepTime);


        Movie movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey,Movie.class);

        //List<Movie> movies =  movieCollection.getMoviesCollection().stream().filter(p -> p.getMovieId().equals(movieId)).collect(Collectors.toList());
        if(movie == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

}
