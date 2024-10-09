package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Category;
import com.example.gestiondestock.Exception.EntityNotFoundException;
import com.example.gestiondestock.Exception.ErrorCodes;
import com.example.gestiondestock.Exception.InvalidEntityException;
import com.example.gestiondestock.Repository.CategoryRepository;
import com.example.gestiondestock.validator.ArticleValidator;
import com.example.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
@Slf4j

public class CategoryService implements ICategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        List<String> errors = CategoryValidator.validate(category);
        if (!errors.isEmpty()) {
            log.error("category is not valid {}", category);
            throw new InvalidEntityException(" category nest pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return categoryRepository.save(category);}

    @Override
    public Category findByIdCategory(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND));}

    @Override
    public Category findByCodeCategory(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)) {
            log.error("Article CODE is null");
            return null;
        }

        return categoryRepository.findCategoriesBycode(codeCategory)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun category avec le CODE = " + codeCategory + " n'a été trouvé dans la BDD",
                                ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Integer id) {
    if (id == null) {
        log.error("Article ID is null");}
         categoryRepository.deleteById(id);

    }
}
