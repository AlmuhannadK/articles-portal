package com.example.articlesportal.controller;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
import com.example.articlesportal.entity.Comment;
import com.example.articlesportal.repository.ArticleRepository;
import com.example.articlesportal.service.ArticleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;


    @PostMapping()
//    @PreAuthorize("hasAnyAuthority(‘USER’)”) --> USERS only
    public ResponseEntity<ArticleDto> postNewArticle(@RequestBody @Valid ArticleDto articleDto) {

        return new ResponseEntity<>(this.articleService.postNewArticle(articleDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("id") @Min(1) Long id) {
        return ResponseEntity.ok(this.articleService.getArticleById(id));
    }

    @GetMapping() //Paginated article list
    public ResponseEntity<Page<ArticleDto>> getArticlesPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.articleService.getAllArticles(pageable));
    }
//
//    // BONUS images here (not important right now)
//
    @DeleteMapping("/{id}")
//    @PreAuthorize("isAuthenticated()") --> user can delete their own articles only (how to specify owner only can del?)
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") Long id) {
        // make sure it's available first, then delete via repository

        // need to fix later
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }



































    /////// Comments ///////
    @PostMapping("/{id}/comment")
//    @PreAuthorize("hasAnyAuthority(‘USER’)”)
    public ResponseEntity<HttpStatus> commentArticle(@PathVariable("id") Long id, @RequestBody Comment comment) { // --> @Valid validate comment
        // fetch article by id via repo, then append created comment
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/comment") //public
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable("id") Long id) {
        // fetch article by id via repo, then show all comments appended to article
        // article.findById(id)
        //article.getComments();

        //return service that has repo return list of comments here
        return ResponseEntity.ok(null);
    }
    ////////////////////////////


    /////// Like & Dislikes ///////
    @PutMapping("/{id}/like")
//    @PreAuthorize("hasAnyAuthority(‘USER’)”) --> users only
    public ResponseEntity<HttpStatus> articleLike(@PathVariable("id") Long id) {
        // fetch article by id, then increment like counter ( set like++?)
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/dislike")
//    @PreAuthorize("hasAnyAuthority(‘USER’)”) --> users only
    public ResponseEntity<HttpStatus> articleDislike(@PathVariable("id") Long id) {
        // fetch article by id, then increment dislike counter ( set dislike++?)
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    ////////////////////////////












}
