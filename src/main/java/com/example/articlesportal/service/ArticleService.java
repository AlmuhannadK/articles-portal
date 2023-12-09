package com.example.articlesportal.service;

import com.example.articlesportal.entity.Article;
import com.example.articlesportal.payload.ArticleDto;
import com.example.articlesportal.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article postNewArticle(Article article) {
        //map to entity
        this.articleRepository.save(article);
        return article;
    }
}


