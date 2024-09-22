package com.example.gestiondestock.Repository;

import com.example.gestiondestock.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
}
