package com.example.articlesportal.service;

import com.example.articlesportal.dto.ArticleDto;
import com.example.articlesportal.entity.Article;
import com.example.articlesportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;







//    //convert Entity to Dto
//    private ArticleDto mapToDto(Article article) {
//        ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
//        return articleDto;
//    }
//    //convert Dto to Entity
//    private Article mapToEntity(ArticleDto articleDto) {
//        Article article = modelMapper.map(articleDto, Article.class);
//        return article;
//    }
}
