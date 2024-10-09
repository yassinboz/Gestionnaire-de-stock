package com.example.gestiondestock.validator;

import com.example.gestiondestock.Entities.Category;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(Category category) {
        List<String> errors = new ArrayList<>();

        if (category == null || !StringUtils.hasLength(category.    getCode())) {
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }

}
