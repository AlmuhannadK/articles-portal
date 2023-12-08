package com.example.articlesportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    //unique
    private String username;

    private String mobileNumber;

    private String password;

    //unique
    private String email;

    //relations
    //many to many
//    private List<Privileges> privileges; --> ROLE_USER

    // one to many
//    private List<Comments> comments;

}
