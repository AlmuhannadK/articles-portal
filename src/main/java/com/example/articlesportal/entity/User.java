package com.example.articlesportal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //unique
    @Column(unique = true)
    private String username;

    private String mobileNumber;

    private String password;

    //unique
    @Column(unique = true)
    private String email;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articles;

    //many to many
//    private List<Privileges> privileges; --> ROLE_USER

    // one to many
//    private List<Comments> comments;

}
