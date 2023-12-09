package com.example.articlesportal.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

    @Size(max = 100)
    private String commentText;

    private String username;
}

