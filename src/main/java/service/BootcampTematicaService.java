package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.BootcampTematica;
import com.example.antivirusAPI.repository.BootcampTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BootcampTematicaService {

    @Autowired
    private BootcampTematicaRepository bootcampTematicaRepository;

    public List<BootcampTematica> findAll() {
        return bootcampTematicaRepository.findAll();
    }

    public Optional<BootcampTematica> findById(Long id) {
        return bootcampTematicaRepository.findById(id);
    }

    public BootcampTematica save(BootcampTematica bootcampTematica) {
        return bootcampTematicaRepository.save(bootcampTematica);
    }

    public void deleteById(Long id) {
        bootcampTematicaRepository.deleteById(id);
    }
}
