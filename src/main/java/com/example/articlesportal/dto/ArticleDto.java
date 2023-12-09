package com.example.articlesportal.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Set;

@Data
public class ArticleDto {

    @NotEmpty
    @Size(min = 2, max = 100, message = "less than 100 characters")
    private String title;

    @NotEmpty
    @Size(min = 2, max = 500, message = "less than 500 characters")
    private String body;

    private Set<CommentDto> comments;



//    private Integer numberOfLikes;
//    private Integer numberOfDislikes;
//    private String author; --> put user entity's (username) after mapping to entity

}
