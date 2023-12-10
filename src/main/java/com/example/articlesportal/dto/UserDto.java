package com.example.articlesportal.dto;

import com.example.articlesportal.entity.Article;
import com.example.articlesportal.entity.Privilege;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    @NotEmpty
    @Size(min = 2, max = 15)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String username;

    @NotEmpty
    @Pattern(regexp = "^\\d{10}$")
    private String mobileNumber;

    @NotEmpty(message = "password must not be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$")
    private String password;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;

    private List<Article> articles;

    private Set<Privilege> privileges;
}
