package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.OportunidadInstitucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadInstitucionRepository extends JpaRepository<OportunidadInstitucion, Long> {
    // Método adicional para buscar por oportunidad
    List<OportunidadInstitucion> findByOportunidadId(Long oportunidadId);

    // Método adicional para buscar por institución
    List<OportunidadInstitucion> findByInstitucionId(Long institucionId);
}
