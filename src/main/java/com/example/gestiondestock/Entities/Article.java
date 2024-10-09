package com.example.gestiondestock.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;
    @ManyToOne
    @JoinColumn(name = "idcategory")

    private Category category;
   @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
   @OneToMany(mappedBy = "article")
    List<MvStk>mvStks;
   @OneToMany(mappedBy = "article")
    private List<LigneVente>ligneVentes;
    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient>ligneCommandeClients;
    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur>ligneCommandeFournisseurs;
}
