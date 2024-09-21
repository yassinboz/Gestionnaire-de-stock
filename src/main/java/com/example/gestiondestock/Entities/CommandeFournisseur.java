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
@Table(name = "commandefournisseur")

public class CommandeFournisseur extends AbstractEntity{
    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;
    private Integer idEntreprise;


    @ManyToOne
private Fournisseur fournisseur;
@OneToMany(mappedBy = "commandeFournisseur")
private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
