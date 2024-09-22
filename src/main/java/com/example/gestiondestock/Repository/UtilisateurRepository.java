package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}
