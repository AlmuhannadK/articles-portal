package com.example.articlesportal.controller;

import com.example.articlesportal.entity.Article;
import com.example.articlesportal.entity.Comment;
import com.example.articlesportal.repository.ArticleRepository;
import com.example.articlesportal.service.ArticleService;
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

    // temporary will remove later (testing)
    @Autowired
    private ArticleRepository repo;


    @PostMapping()
//    @PreAuthorize("hasAnyAuthority(‘USER’)”) --> USERS only
    public ResponseEntity<Article> postNewArticle(@RequestBody Article article) { // --> @Valid validate article
        return ResponseEntity.ok(this.articleService.postNewArticle(article));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable("id") Long id) {
        // fetch article by id from repo, then store in variable and return

        //temp
        Article article = new Article();
        return ResponseEntity.ok(article);
    }

    @GetMapping() //Paginated article list
    public ResponseEntity<Page<Article>> getArticlesPaginated(Pageable pageable) {
        return ResponseEntity.ok(this.repo.findAllArticles(pageable));
    }

    // BONUS images here (not important right now)

    @DeleteMapping("/{id}")
//    @PreAuthorize("isAuthenticated()") --> user can delete their own articles only (how to specify owner only can del?)
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        // make sure it's available first, then delete via repository

        // need to fix later
        return null;
    }

    /////// Comments ///////
    @PostMapping("/{id}/comment")
//    @PreAuthorize("hasAnyAuthority(‘USER’)”)
    public ResponseEntity<HttpStatus> commentArticle(@PathVariable("id") Long id, @RequestBody Comment comment) { // --> @Valid validate comment
        // fetch article by id via repo, then append created comment
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
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
