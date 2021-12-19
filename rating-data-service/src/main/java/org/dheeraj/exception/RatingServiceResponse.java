package org.dheeraj.exception;

import org.springframework.http.HttpStatus;

public class RatingServiceResponse<T> {
    private HttpStatus httpStatus;
    private T response;
    private String message;
    private String error;

    public RatingServiceResponse() {
    }

    public RatingServiceResponse(HttpStatus httpStatus, T response, String message, String error) {
        this.httpStatus = httpStatus;
        this.response = response;
        this.message = message;
        this.error = error;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
