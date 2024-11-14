package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.Tematica;
import com.example.antivirusAPI.repository.TematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TematicaService {

    @Autowired
    private TematicaRepository tematicaRepository;

    public List<Tematica> findAll() {
        return tematicaRepository.findAll();
    }

    public Optional<Tematica> findById(Long id) {
        return tematicaRepository.findById(id);
    }

    public Tematica save(Tematica tematica) {
        return tematicaRepository.save(tematica);
    }

    public void deleteById(Long id) {
        tematicaRepository.deleteById(id);
    }
}
