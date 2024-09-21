package com.example.gestiondestock.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")

public class Client extends AbstractEntity{
    private Integer id;

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;

}
