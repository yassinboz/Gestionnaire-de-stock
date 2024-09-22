package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes,Integer> {
}
