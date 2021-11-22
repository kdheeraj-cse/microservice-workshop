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
            new Rating(1, 1, 100, "1/5"),
            new Rating(2, 1, 101, "2/5"),
            new Rating(3, 1, 102, "3/5"),
            new Rating(4, 2, 103, "4/5"),
            new Rating(5, 2, 104, "5/5"),
            new Rating(6, 2, 105, "1/5"),
            new Rating(7, 3, 106, "2/5"),
            new Rating(8, 3, 107, "3/5"),
            new Rating(9, 4, 108, "4/5"),
            new Rating(10, 4, 109, "1/5"),
            new Rating(11, 4, 110, "2/5"),
            new Rating(12, 4, 111, "2/5"),
            new Rating(13, 5, 112, "3/5"),
            new Rating(14, 6, 113, "4/5"),
            new Rating(15, 6, 114, "5/5"),
            new Rating(16, 7, 115, "1/5"),
            new Rating(17, 7, 116, "2/5"),
            new Rating(18, 7, 117, "3/5"),
            new Rating(19, 7, 118, "4/5")

        ).collect(Collectors.toList());
    }

    public List<Rating> getRatingCollection() {
        return ratingCollection;
    }
 
}
