package com.example.gestiondestock.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Entreprise")

public class Entreprise extends AbstractEntity{
    private String nom;

    private String description;

    private Adresse adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String numTel;

    private String steWeb;
    @OneToMany(mappedBy = "entreprise")
    List<Utilisateur>utilisateurs;

}
