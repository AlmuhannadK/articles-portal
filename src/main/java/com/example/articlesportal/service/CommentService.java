package com.example.articlesportal.service;

import com.example.articlesportal.dto.CommentDto;
import com.example.articlesportal.entity.Article;
import com.example.articlesportal.entity.Comment;
import com.example.articlesportal.exception.ResourceNotFoundException;
import com.example.articlesportal.repository.ArticleRepository;
import com.example.articlesportal.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;


    public CommentDto createComment(Long id, CommentDto commentDto) {

        Comment comment = mapToEntity(commentDto);
        Article article = this.articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
        // set article to comment entity
        comment.setArticle(article);

        Comment newComment = this.commentRepository.save(comment);
        return mapToDto(newComment);
    }

    public List<CommentDto> getCommentsByArticleId(Long articleId) {

        List<Comment> comments = this.commentRepository.findByArticleId(articleId);

        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

                        // mappers
    private CommentDto mapToDto(Comment comment) {
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        return commentDto;
    }
    private Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}
