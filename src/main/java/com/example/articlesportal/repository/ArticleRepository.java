package com.example.articlesportal.repository;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

//    Page<Article> findAllArticles(Pageable pageable); // fetch articles paginated (use in service)

//    Page<Article> getAllArticles(Pageable pageable);

//    Page<Article> findAll(Pageable pageable);
}
