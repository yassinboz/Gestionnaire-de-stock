package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
    List<LigneCommandeClient> findAllByArticleId(Integer id);

}
