package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.BootcampTematica;
import com.example.antivirusAPI.repository.BootcampTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootcampTematicaService {

    @Autowired
    private BootcampTematicaRepository repository;

    public List<BootcampTematica> getAll() {
        return repository.findAll();
    }

    public BootcampTematica getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public BootcampTematica save(BootcampTematica bootcampTematica) {
        return repository.save(bootcampTematica);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
