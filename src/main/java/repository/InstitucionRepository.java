package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitucionRepository extends JpaRepository<Institucion, Long> {
    // Método adicional para buscar instituciones que contengan un nombre específico
    List<Institucion> findByNombreContaining(String nombre);
}
