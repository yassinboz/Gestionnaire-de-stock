package com.example.gestiondestock.Controlleur;

import com.example.gestiondestock.Entities.Article;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GestionArticle")

public interface IarticleController {
    @PostMapping(value = "/articles/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
     Article addArticle(@RequestBody Article article);
    @GetMapping(value = "/articles/findbyid/{id}",

            produces = MediaType.APPLICATION_JSON_VALUE)
     Article getArticle(@PathVariable Integer id);
    @GetMapping(value = "/articles/findbycode/{code}",
            produces = MediaType.APPLICATION_JSON_VALUE)
      Article getArticleByCode (@PathVariable String code);
    @GetMapping(value = "/articles/getall",
            produces = MediaType.APPLICATION_JSON_VALUE)
     List<Article> getAllArticle();
    @DeleteMapping(value = "/articles/delete/{id}")
     void deleteArticle(@PathVariable Integer id) ;
    }

