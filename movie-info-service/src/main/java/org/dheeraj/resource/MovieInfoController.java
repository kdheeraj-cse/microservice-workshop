package org.dheeraj.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.dheeraj.dataSource.MovieCollection;
import org.dheeraj.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {
    
    @Autowired
    MovieCollection movieCollection;

    @GetMapping("/getMovieInfo/{movieId}")
    public ResponseEntity<Movie> getMovieInformation(@PathVariable("movieId") Integer movieId){
        List<Movie> movies =  movieCollection.getMoviesCollection().stream().filter(p -> p.getMovieId().equals(movieId)).collect(Collectors.toList());
        if(movies.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(movies.get(0));
    }

}
