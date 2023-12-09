package com.example.articlesportal.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

    @NotEmpty
    @Size(min = 2, max = 100, message = "less than 100 characters")
    private String title;

    @NotEmpty
    @Size(min = 2, max = 500, message = "less than 500 characters")
    private String body;

//    private String author;
//    private Integer numberOfLikes;
//    private Integer numberOfDislikes;
}
