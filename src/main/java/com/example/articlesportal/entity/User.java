package com.example.articlesportal.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_privilege",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "privilege_name", referencedColumnName = "name")})
    private Set<Privilege> privileges = new HashSet<>();


}
