package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {
}
