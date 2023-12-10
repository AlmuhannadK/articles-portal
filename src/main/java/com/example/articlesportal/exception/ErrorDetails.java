package com.example.articlesportal.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {
    private HttpStatus status;
    private Date timestamp;
    private String message;

    public ErrorDetails(HttpStatus status, Date timestamp, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
