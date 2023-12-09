package com.example.articlesportal.controller;

import com.example.articlesportal.entity.Article;
import com.example.articlesportal.entity.User;
import com.example.articlesportal.repository.ArticleRepository;
import com.example.articlesportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class AdminController {


    @PutMapping("/{id}/disable")
    //    @PreAuthorize("hasAnyAuthority(‘ADMIN’)”) --> ADMIN only
    public ResponseEntity<HttpStatus> disableArticle(@PathVariable("id") Long id) {
        // fetch article by id, then make isDisabled set to true (hides article)
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/enable")
    //    @PreAuthorize("hasAnyAuthority(‘ADMIN’)”) --> ADMIN only
    public ResponseEntity<HttpStatus> enableArticle(@PathVariable("id") Long id) {
        // fetch article by id, then make isDisabled set to false (shows article)
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
