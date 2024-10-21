package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.Institucion;
import com.example.antivirusAPI.repository.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionService {

    @Autowired
    private InstitucionRepository institucionRepository;

    public List<Institucion> findAll() {
        return institucionRepository.findAll();
    }

    public Optional<Institucion> findById(Long id) {
        return institucionRepository.findById(id);
    }

    public Institucion save(Institucion institucion) {
        return institucionRepository.save(institucion);
    }

    public void deleteById(Long id) {
        institucionRepository.deleteById(id);
    }
}
