package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {
    List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);

}
