package com.example.articlesportal.controller;

import com.example.articlesportal.dto.CommentDto;
import com.example.articlesportal.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article/{id}/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("")
//    @PreAuthorize("hasAnyAuthority(‘USER’)”)
    public ResponseEntity<CommentDto> commentArticle(@PathVariable("id") Long id, @RequestBody @Valid CommentDto commentDto) {
        return new ResponseEntity<>(this.commentService.createComment(id,commentDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CommentDto>> getCommentsByArticleId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.commentService.getCommentsByArticleId(id));
    }
}
