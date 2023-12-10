package com.example.articlesportal.exception;

import org.springframework.http.HttpStatus;

public class ArticleAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ArticleAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ArticleAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }
    @Override
    public String getMessage() {
        return message;
    }
}