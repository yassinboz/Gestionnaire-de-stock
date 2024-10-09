package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Article;
import com.example.gestiondestock.Entities.Client;
import com.example.gestiondestock.Entities.CommandeClient;
import com.example.gestiondestock.Entities.LigneCommandeClient;
import com.example.gestiondestock.Exception.EntityNotFoundException;
import com.example.gestiondestock.Exception.ErrorCodes;
import com.example.gestiondestock.Exception.InvalidEntityException;
import com.example.gestiondestock.Repository.ArticleRepository;
import com.example.gestiondestock.Repository.ClientRepository;
import com.example.gestiondestock.Repository.CommandeClientRepository;
import com.example.gestiondestock.Repository.LigneCommandeClientRepository;
import com.example.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeClientService implements ICommandeService {
    @Autowired
    CommandeClientRepository commandeClientRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    LigneCommandeClientRepository ligneCommandeClient;

    @Override
    public CommandeClient save(CommandeClient commandeClient) {
        // Validation de la commande client

        List<String> errors = CommandeClientValidator.validate(commandeClient);

        if (!errors.isEmpty()) {
            log.error("Commande client n'est pas valide");
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        // Vérification de l'existence du client
        Optional<Client> client = clientRepository.findById(commandeClient.getClient().getId());
        if (client.isEmpty()) {
            log.warn("Client avec ID {} n'a pas été trouvé dans la BDD", commandeClient.getClient().getId());
            throw new InvalidEntityException("Aucun client avec l'ID " + commandeClient.getClient().getId() + " n'a été trouvé dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);
        }

        // Vérification des articles associés aux lignes de commande
        List<String> articleErrors = new ArrayList<>();
        if (commandeClient.getLigneCommandeClients() != null) {
            commandeClient.getLigneCommandeClients().forEach(ligneCommandeClient -> {
                if (ligneCommandeClient.getArticle() == null || ligneCommandeClient.getArticle().getId() == null) {
                    articleErrors.add("L'article associé à la ligne de commande est nul ou non valide.");
                } else {
                    Optional<Article> article = articleRepository.findById(ligneCommandeClient.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("Aucun article avec l'ID " + ligneCommandeClient.getArticle().getId() + " n'a été trouvé dans la BDD.");
                    }
                }
            });
        }

        // Si des erreurs d'article existent, on lance une exception
        if (!articleErrors.isEmpty()) {
            log.warn("Des articles associés à la commande sont invalides.");
            throw new InvalidEntityException("Articles invalides dans la commande", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        // Sauvegarde de la commande client
        //et l'objet enregistré est stocké dans savedCommandeClient.

        CommandeClient savedCommandeClient = commandeClientRepository.save(commandeClient);

        // Sauvegarde des lignes de commande clients associées
        commandeClient.getLigneCommandeClients().forEach(ligneCommandeClient1 -> {
            ligneCommandeClient1.setCommandeClient(savedCommandeClient);
            ligneCommandeClient.save(ligneCommandeClient1);
        });

        return savedCommandeClient;
    }

    @Override
    public CommandeClient findbyId(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return null;
        }
        return commandeClientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClient findByCode(String code) {
                if (!StringUtils.hasLength(code)) {
                    log.error("Commande client CODE is NULL");
                    return null;
                }
        return commandeClientRepository.findCommandeClientByCode(code)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune commande client n'a ete trouve avec le CODE " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));

}

    @Override
    public List<CommandeClient> findall() {
        return commandeClientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Commande client ID is NULL");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
