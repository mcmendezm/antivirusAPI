package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.Oportunidad;
import com.example.antivirusAPI.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadService {

    @Autowired
    private OportunidadRepository oportunidadRepository;

    public List<Oportunidad> findAll() {
        return oportunidadRepository.findAll();
    }

    public Optional<Oportunidad> findById(Long id) {
        return oportunidadRepository.findById(id);
    }

    public Oportunidad save(Oportunidad oportunidad) {
        return oportunidadRepository.save(oportunidad);
    }

    public void deleteById(Long id) {
        oportunidadRepository.deleteById(id);
    }
}
