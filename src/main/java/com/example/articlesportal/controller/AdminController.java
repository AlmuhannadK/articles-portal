package com.example.articlesportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
