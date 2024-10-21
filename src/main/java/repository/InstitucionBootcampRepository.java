package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.InstitucionBootcamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionBootcampRepository extends JpaRepository<InstitucionBootcamp, Long> {
}
