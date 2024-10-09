package com.example.gestiondestock.Controlleur;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Entities.Category;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GestionCategory")
public interface ICategoryController {
    @PostMapping(value = "/category/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Category addCategory(@RequestBody Category category);
    @GetMapping(value = "/category/findbyid/{id}",

            produces = MediaType.APPLICATION_JSON_VALUE)
    Category findByIdCategory(@PathVariable Integer id);
    @GetMapping(value = "/category/findbycode/{code}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    Category findByCodeCategory (@PathVariable String code);
    @GetMapping(value = "/category/getall",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<Category> getAllCategory();
    @DeleteMapping(value = "/category/delete/{id}")
    void deleteCategory(@PathVariable Integer id) ;


}
