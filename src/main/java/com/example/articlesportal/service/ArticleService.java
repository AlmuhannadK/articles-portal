package com.example.articlesportal.service;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
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
            optionalArticle.orElseThrow();
        }
        return null;
    }


    public List<ArticleDto> getAllArticles(Pageable pageable) {

//        Pageable pageable = PageRequest.of(pageable);
        Page<Article> articles = this.articleRepository.findAll(pageable);

        // get content from page object
        List<Article> listOfArticles = articles.getContent();

        return listOfArticles.stream().map(article -> mapToDto(article)).collect(Collectors.toList());
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


