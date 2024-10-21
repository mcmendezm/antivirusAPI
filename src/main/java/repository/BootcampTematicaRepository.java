package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.BootcampTematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampTematicaRepository extends JpaRepository<BootcampTematica, Long> {
}
