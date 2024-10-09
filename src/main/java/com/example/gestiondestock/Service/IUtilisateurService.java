package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    Utilisateur save(Utilisateur utilisateur);

    Utilisateur findById(Integer id);

    List<Utilisateur> findAll();

    void delete(Integer id);

    //Utilisateur findByEmail(String email);

    //Utilisateur changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);
}
