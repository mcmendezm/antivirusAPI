package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.BootcampTematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampTematicaRepository extends JpaRepository<BootcampTematica, Long> {
    // Método adicional para buscar relaciones por bootcamp
    List<BootcampTematica> findByBootcampId(Long bootcampId);

    // Método adicional para buscar relaciones por temática
    List<BootcampTematica> findByTematicaId(Long tematicaId);
}
