package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    Optional<Category> findCategoriesBycode(String codeArticle);

}
