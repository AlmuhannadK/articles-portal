package com.example.articlesportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "privileges")
@Getter
@Setter
@NoArgsConstructor
public class Privilege {

    @Id
    @Column(length = 16)
    private String name;

}
