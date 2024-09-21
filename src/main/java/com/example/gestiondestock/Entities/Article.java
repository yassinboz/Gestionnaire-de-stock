package com.example.gestiondestock.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article")
@EqualsAndHashCode(callSuper = true)

public class Article extends AbstractEntity{
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
