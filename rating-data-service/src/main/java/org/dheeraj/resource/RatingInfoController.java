package org.dheeraj.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.dheeraj.datasource.RatingCollection;
import org.dheeraj.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingInfoController {
    
    @Autowired
    private RatingCollection ratingCollection;

    @GetMapping("/getRatings/{userId}")
    public ResponseEntity<List<Rating>> getUserRatings(@PathVariable("userId") Integer userId){
        
        return ResponseEntity.ok().body(ratingCollection.getRatingCollection().stream().filter(rating -> rating.getUserId().equals(userId)).collect(Collectors.toList()));

    }
}
