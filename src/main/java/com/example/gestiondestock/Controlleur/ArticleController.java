package com.example.gestiondestock.Controlleur;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class ArticleController implements IarticleController {
    @Autowired
    ArticleService articleService;
    @Override
    public Article addArticle(Article article) {
        return articleService.addArticle(article);
    }

    @Override
    public Article getArticle(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public Article getArticleByCode(String code) {
        return articleService.findByCodeArticle(code);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleService.findAll();
    }

    @Override
    public void deleteArticle(Integer id) {

    }
}
