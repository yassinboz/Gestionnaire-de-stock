package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.CommandeClient;

import java.util.List;

public interface ICommandeService {
    CommandeClient save(CommandeClient dto);
    CommandeClient findbyId(Integer id);
    CommandeClient findByCode(String code);
    List<CommandeClient> findall ();
    void delete(Integer id);

}
