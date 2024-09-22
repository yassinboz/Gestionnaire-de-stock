package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ArticleService implements IArticleService{
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public Article save(Article dto) {
        return articleRepository.save(dto);
    }

    @Override
    public Article findById(Integer id) {
      Article article =articleRepository.findById(id).orElseThrow(()->new RuntimeException("Article not found"));
        return article;
    }

    @Override
    public Article findByCodeArticle(String codeArticle) {
        Article article = articleRepository.findArticleByCodeArticle(codeArticle);
        return  article ;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
