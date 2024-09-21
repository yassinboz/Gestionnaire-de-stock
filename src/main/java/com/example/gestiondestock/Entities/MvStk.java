package com.example.gestiondestock.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MvStk extends AbstractEntity{
    private Instant dateMvt;

    private BigDecimal quantite;

    private TypeMvtStk typeMvt;

    private SourceMvtStk sourceMvt;

    private Integer idEntreprise;
    @ManyToOne
    @JoinColumn(name = "idarticle")

    private Article article;
}
