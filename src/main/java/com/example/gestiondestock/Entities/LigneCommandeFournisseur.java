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
@Table(name = "lignecommandefournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idcommandefournisseur")

    CommandeFournisseur commandeFournisseur;
        @ManyToOne
        @JoinColumn(name = "idarticle")
        private Article article;
}
