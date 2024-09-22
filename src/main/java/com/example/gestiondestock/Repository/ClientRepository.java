package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
