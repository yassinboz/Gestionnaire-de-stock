package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Optional<Article> findArticleByCodeArticle(String codeArticle);
}
