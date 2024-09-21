package com.example.gestiondestock.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lignecommandeclient")

public class LigneCommandeClient extends AbstractEntity{

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;
}
