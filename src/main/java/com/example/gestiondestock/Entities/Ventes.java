package com.example.gestiondestock.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Ventes")
public class Ventes extends AbstractEntity{
    private String code;

    private Instant dateVente;

    private String commentaire;
    private Integer idEntreprise;

    @OneToMany (mappedBy = "vente")
    List<LigneVente> ligneVenteList;
}
