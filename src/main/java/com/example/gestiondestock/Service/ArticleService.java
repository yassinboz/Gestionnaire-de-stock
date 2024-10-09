package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Entities.CommandeClient;
import com.example.gestiondestock.Entities.LigneCommandeClient;
import com.example.gestiondestock.Entities.LigneCommandeFournisseur;
import com.example.gestiondestock.Exception.EntityNotFoundException;
import com.example.gestiondestock.Exception.ErrorCodes;
import com.example.gestiondestock.Exception.InvalidEntityException;
import com.example.gestiondestock.Exception.InvalidOperationException;
import com.example.gestiondestock.Repository.ArticleRepository;
import com.example.gestiondestock.Repository.CommandeClientRepository;
import com.example.gestiondestock.Repository.LigneCommandeClientRepository;
import com.example.gestiondestock.Repository.LigneCommandeFournisseurRepository;
import com.example.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

@Service
@Slf4j


public class ArticleService implements IArticleService{
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LigneCommandeClientRepository commandeClientRepository;
@Autowired
LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Override
    public Article addArticle(Article article) {

        List<String> errors = ArticleValidator.validate(article);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", article);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return articleRepository.save(article);}

    @Override
    public Article findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return articleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));}


    @Override
    public Article findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return null;
        }

        return articleRepository.findArticleByCodeArticle(codeArticle)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Aucun article avec le CODE = " + codeArticle + " n'a été trouvé dans la BDD",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }


    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void deleteArticle(Integer id) {
        if (id == null)     {
            log.error("Article ID is null");
            return;

       // List<LigneCommandeClient>ligneCommandeClients= commandeClientRepository.findAllByArticleId(id);
        //if (!ligneCommandeClients.isEmpty()) {
          //  throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
       // }
        //List<LigneCommandeFournisseur> ligneCommandeFournisseurs = ligneCommandeFournisseurRepository.findAllByArticleId(id);
        //if (!ligneCommandeFournisseurs.isEmpty()) {
          //  throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
              //      ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        articleRepository.deleteById(id);

    }
}

