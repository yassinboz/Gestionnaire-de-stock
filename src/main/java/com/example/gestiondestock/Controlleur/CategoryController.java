package com.example.gestiondestock.Controlleur;

import com.example.gestiondestock.Entities.Category;
import com.example.gestiondestock.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController


public class CategoryController implements ICategoryController{
    @Autowired
    CategoryService categoryService;
    @Override
    public Category addCategory(Category category) {
        return categoryService.addCategory(category);
    }

    @Override
    public Category findByIdCategory(Integer id) {
        return categoryService.findByIdCategory(id);
    }

    @Override
    public Category findByCodeCategory(String code) {
        return categoryService.findByCodeCategory(code);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryService.findAllCategory();
    }

    @Override
    public void deleteCategory(Integer id) {
    categoryService.deleteCategory(id);
    }
}
