package com.example.articlesportal.service;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
import com.example.articlesportal.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    private final ModelMapper modelMapper;


    public ArticleDto postNewArticle(ArticleDto articleDto) {

        // convert to entity
        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setBody(articleDto.getBody());
        article.setIsDisabled(false);
        article.setNumberOfLikes(0);
        article.setNumberOfDislikes(0);
        // article.setAuthor();  --> current logged in user

        Article newArticle = this.articleRepository.save(article);

        // convert back to dto to return
        ArticleDto articleResponse = new ArticleDto();
        articleResponse.setTitle(newArticle.getTitle());
        articleResponse.setBody(newArticle.getBody());

        return articleResponse;
    }

    public ArticleDto getArticleById(Long id) {

        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            // map to dto
            ArticleDto articleDto = new ArticleDto();
            articleDto.setTitle(article.getTitle());
            articleDto.setBody(article.getBody());
            return articleDto;
        }else{
            optionalArticle.orElseThrow();
        }
        return null;
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


