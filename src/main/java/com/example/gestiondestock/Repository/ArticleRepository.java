package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Article findArticleByCodeArticle(String codeArticle );
}
