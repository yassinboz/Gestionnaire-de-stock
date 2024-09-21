package com.example.gestiondestock.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignevente")

public class LigneVente extends AbstractEntity{
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    Article article;
    @ManyToOne
   @JoinColumn(name = "idvente")

    Ventes vente;
}
