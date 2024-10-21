package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {
    // Método adicional para buscar oportunidades por tipo
    List<Oportunidad> findByTipo(String tipo);

    // Método adicional para buscar oportunidades por categoría
    List<Oportunidad> findByCategoriaId(Long categoriaId);
}
