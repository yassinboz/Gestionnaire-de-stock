package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
}
