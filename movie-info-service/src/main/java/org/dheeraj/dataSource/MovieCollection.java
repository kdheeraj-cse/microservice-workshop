package org.dheeraj.dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.dheeraj.models.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieCollection {

    private List<Movie> moviesCollection;

    @PostConstruct
    public void initMovieCollection() {
        moviesCollection = List.of(
            new Movie(1, "Terminator", "Action"),
            new Movie(2, "Conjuring", "Horror"),
            new Movie(3, "Fifty Shades of Grey", "Thriller"),
            new Movie(4, "Valentine Day", "Romance"),
            new Movie(5, "Titanic", "Romance"),
            new Movie(6, "Avatar", "Scifi"),
            new Movie(7, "Imitation Game", "Documentry"),
            new Movie(8, "She is the Men", "Comedy"),
            new Movie(9, "Back to the future", "Scifi"),
            new Movie(10, "Ford vs Ferrari", "Action")
            );
    }

    public List<Movie> getMoviesCollection() {
        return moviesCollection;
    }
}
