package com.example.articlesportal.dto;

import jakarta.validation.constraints.Size;

public class CommentDto {

    @Size(max = 100)
    private String commentText;

    //logged in user
    //private String username;
}

