package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Article;

import java.util.List;

public interface IArticleService {
    Article save(Article dto);

    Article findById(Integer id);

    Article findByCodeArticle(String codeArticle);

    List<Article> findAll();
}
