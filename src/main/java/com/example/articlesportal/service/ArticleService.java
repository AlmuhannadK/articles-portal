package com.example.articlesportal.service;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
import com.example.articlesportal.exception.ResourceNotFoundException;
import com.example.articlesportal.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;


    public ArticleDto postNewArticle(ArticleDto articleDto) {

        Article article = mapToEntity(articleDto);
//        article.setIsDisabled(false);
        this.articleRepository.save(article);
        return articleDto;
    }

    public ArticleDto getArticleById(Long id) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article articleEntity = optionalArticle.get();
            ArticleDto articleDto = mapToDto(articleEntity);
            return articleDto;
        } else {
            optionalArticle.orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
        }
        return null;
    }

    public Page<ArticleDto> getAllArticles(Pageable pageable) {

        Page<Article> articles = this.articleRepository.findAll(pageable);
        return articles.map(article -> mapToDto(article));
    }

    public void deleteArticleById(Long id) {

        Article article = this.articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article", "id", id));
        this.articleRepository.delete(article);
    }

    public HttpStatus likeArticle(Long id) {

        Optional<Article> optionalArticle = Optional.ofNullable(this.articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", id)));

            Article article = optionalArticle.get();

            Integer likes = article.getNumberOfLikes();
            likes = likes + 1;
            article.setNumberOfLikes(likes);
            this.articleRepository.save(article);

            return HttpStatus.ACCEPTED;
    }
    public HttpStatus dislikeArticle(Long id) {

        Optional<Article> optionalArticle = Optional.ofNullable(this.articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article", "id", id)));

            Article article = optionalArticle.get();

            Integer dislikes = article.getNumberOfDislikes();
            dislikes = dislikes + 1;
            article.setNumberOfDislikes(dislikes);
            this.articleRepository.save(article);

            return HttpStatus.ACCEPTED;
    }

    //convert Entity to Dto
    private ArticleDto mapToDto(Article article) {
        ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
        return articleDto;
    }
    //convert Dto to Entity
    private Article mapToEntity(ArticleDto articleDto) {
        Article article = modelMapper.map(articleDto, Article.class);
        return article;
    }
}


