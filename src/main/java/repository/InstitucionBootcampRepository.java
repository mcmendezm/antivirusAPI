package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.InstitucionBootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitucionBootcampRepository extends JpaRepository<InstitucionBootcamp, Long> {
    // Método adicional para buscar relaciones por institución
    List<InstitucionBootcamp> findByInstitucionId(Long institucionId);

    // Método adicional para buscar relaciones por bootcamp
    List<InstitucionBootcamp> findByBootcampId(Long bootcampId);
}
