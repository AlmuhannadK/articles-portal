package com.example.articlesportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; //less than 100 chars

    @Column(columnDefinition = "TEXT")
    private String body; // less than 500 chars

    //one to one relation, ref username?
    private String author; // logged in username(User)

    @CreationTimestamp
    private LocalDateTime createdAt;

//    private String image; (bonus)

    private Integer numberOfLikes;

    private Integer numberOfDislikes;

    private Boolean isDisabled;


}
