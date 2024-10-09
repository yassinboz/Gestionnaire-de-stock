package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Utilisateur;
import com.example.gestiondestock.Exception.EntityNotFoundException;
import com.example.gestiondestock.Exception.ErrorCodes;
import com.example.gestiondestock.Exception.InvalidEntityException;
import com.example.gestiondestock.Repository.UtilisateurRepository;
import com.example.gestiondestock.validator.ClientValidator;
import com.example.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UtilisateurService implements IUtilisateurService{
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        List<String> errors = UtilisateurValidator.validate(utilisateur);
        if (!errors.isEmpty()) {
            log.error("utilisateur is not valid {}", utilisateur);
            throw new InvalidEntityException(" utilisateur nest pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        return utilisateurRepository.save(utilisateur);}

    @Override
    public Utilisateur findById(Integer id) {
        if (id == null) {
            log.error(" utilisateur ID is null");
            return null;
        }
        return utilisateurRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND));}

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Client ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }

    }

