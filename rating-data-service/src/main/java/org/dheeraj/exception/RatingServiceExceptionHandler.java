package org.dheeraj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RatingServiceExceptionHandler {

    @ExceptionHandler(NoRatingFoundException.class)
    ResponseEntity<RatingServiceResponse> handleNoRatingFoundException(NoRatingFoundException exception){
      RatingServiceResponse response = new RatingServiceResponse(HttpStatus.NOT_FOUND,null,"", exception.getMessage());
      return ResponseEntity.status(response.getHttpStatus()).body(response);
    };
}
