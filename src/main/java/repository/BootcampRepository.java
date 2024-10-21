package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {
    // Método adicional para buscar bootcamps por institución
    List<Bootcamp> findByInstitucionId(Long institucionId);

    // Método adicional para buscar bootcamps por temática
    List<Bootcamp> findByTematicaId(Long tematicaId);
}
