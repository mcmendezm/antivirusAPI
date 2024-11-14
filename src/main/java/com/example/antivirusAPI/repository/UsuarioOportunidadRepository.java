package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.UsuarioOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioOportunidadRepository extends JpaRepository<UsuarioOportunidad, Long> {
    // Método adicional para buscar relaciones por usuario
    List<UsuarioOportunidad> findByUsuarioId(Long usuarioId);

    // Método adicional para buscar relaciones por oportunidad
    List<UsuarioOportunidad> findByOportunidadId(Long oportunidadId);
}
