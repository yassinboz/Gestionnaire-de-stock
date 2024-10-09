package com.example.gestiondestock.Service;

import com.example.gestiondestock.Entities.Client;
import com.example.gestiondestock.Exception.EntityNotFoundException;
import com.example.gestiondestock.Exception.ErrorCodes;
import com.example.gestiondestock.Exception.InvalidEntityException;
import com.example.gestiondestock.Repository.ClientRepository;
import com.example.gestiondestock.validator.CategoryValidator;
import com.example.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class ClientService implements IClientService{
    @Autowired
    ClientRepository     clientRepository;
    @Override
    public Client save(Client client) {
        List<String> errors = ClientValidator.validate(client);
        if (!errors.isEmpty()) {
            log.error("client is not valid {}", client);
            throw new InvalidEntityException(" client nest pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return clientRepository.save(client);}

    @Override
    public Client findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        return clientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun client avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND));}

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
      if (id==null){
          log.error("Client ID is null");
          return;
      }
      clientRepository.deleteById(id);
    }
}
