package com.example.articlesportal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifier;

    //unique
    @Column(unique = true)
    private String username;

    private String mobileNumber;

    private String password;

    //unique
    @Column(unique = true)
    private String email;

    //relations
    //many to many
//    private List<Privileges> privileges; --> ROLE_USER

    // one to many
//    private List<Comments> comments;

}
