package com.example.articlesportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
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


    @CreationTimestamp
    private LocalDateTime createdAt;


    private Integer numberOfLikes;

    private Integer numberOfDislikes;

    private Boolean isDisabled;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User author;



}
