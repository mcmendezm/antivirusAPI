package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Tematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TematicaRepository extends JpaRepository<Tematica, Long> {
    // Método adicional para buscar por nombre
    Tematica findByNombre(String nombre);
}
