package com.example.gestiondestock.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commandeclient")

public class CommandeClient extends AbstractEntity{
    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;


    private Integer idEntreprise;
    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;


}
