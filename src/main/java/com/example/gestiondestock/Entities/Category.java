package com.example.gestiondestock.Entities;

import jakarta.persistence.Column;
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
@Table(name = "category")

public class Category extends AbstractEntity {
    private String code;

    private String designation;

    private Integer idEntreprise;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
