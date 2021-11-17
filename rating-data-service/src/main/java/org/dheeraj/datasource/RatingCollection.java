package org.dheeraj.datasource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.dheeraj.models.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingCollection {
    
    private List<Rating> ratingCollection;

    @PostConstruct
    public void initRatingCollection(){
        ratingCollection = Stream.of(
            new Rating(1, 1, 1, "1/5"),
            new Rating(2, 1, 2, "2/5"),
            new Rating(3, 1, 3, "3/5"),
            new Rating(4, 2, 4, "4/5"),
            new Rating(5, 2, 5, "5/5"),
            new Rating(6, 2, 6, "1/5"),
            new Rating(7, 3, 7, "2/5"),
            new Rating(8, 3, 8, "3/5"),
            new Rating(9, 4, 9, "4/5"),
            new Rating(10, 4, 10, "1/5"),
            new Rating(11, 4, 1, "2/5"),
            new Rating(12, 4, 2, "2/5"),
            new Rating(13, 5, 3, "3/5"),
            new Rating(14, 6, 4, "4/5"),
            new Rating(15, 6, 5, "5/5"),
            new Rating(16, 7, 6, "1/5"),
            new Rating(17, 7, 7, "2/5"),
            new Rating(18, 7, 8, "3/5"),
            new Rating(19, 7, 9, "4/5")

        ).collect(Collectors.toList());
    }

    public List<Rating> getRatingCollection() {
        return ratingCollection;
    }
 
}
