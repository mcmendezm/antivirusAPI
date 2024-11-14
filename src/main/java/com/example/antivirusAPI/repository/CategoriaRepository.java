package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Método adicional para buscar categorías por nombre
    Categoria findByNombre(String nombre);
}
