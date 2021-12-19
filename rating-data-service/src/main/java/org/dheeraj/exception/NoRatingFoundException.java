package org.dheeraj.exception;

public class NoRatingFoundException extends Exception {
    public NoRatingFoundException(String message){
        super(message);
    }

    public NoRatingFoundException(String message, Throwable throwable){
        super(message,throwable);
    }

}
