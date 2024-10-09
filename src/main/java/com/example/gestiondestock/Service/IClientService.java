package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Client;

import java.util.List;

public interface IClientService {
    Client save(Client client);

    Client findById(Integer id);

    List<Client> findAll();

    void delete(Integer id);
}
