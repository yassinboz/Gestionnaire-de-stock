package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
}
