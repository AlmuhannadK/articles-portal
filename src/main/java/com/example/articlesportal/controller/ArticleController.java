package com.example.articlesportal.controller;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.dto.CommentDto;
import com.example.articlesportal.entity.Comment;
import com.example.articlesportal.service.ArticleService;
import com.example.articlesportal.service.CommentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;


    @PostMapping()
    @PreAuthorize("hasRole('USER')")
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

    // user can delete their own articles only (how to specify owner only can del?)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> deleteArticle(@PathVariable("id") Long id) {

        this.articleService.deleteArticleById(id);
        return ResponseEntity.ok("Article deleted successfully!");
    }



                                        /////// Like & Dislikes ///////
    @PutMapping("/{id}/like")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HttpStatus> articleLike(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.articleService.likeArticle(id));
    }

    @PutMapping("/{id}/dislike")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<HttpStatus> articleDislike(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.articleService.dislikeArticle(id));
    }

}
