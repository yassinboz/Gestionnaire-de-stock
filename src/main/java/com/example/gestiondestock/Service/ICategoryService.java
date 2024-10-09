package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Entities.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);

    Category findByIdCategory(Integer id);

    Category findByCodeCategory(String codeCategory);

    List<Category> findAllCategory();
    void  deleteCategory(Integer id);
}
