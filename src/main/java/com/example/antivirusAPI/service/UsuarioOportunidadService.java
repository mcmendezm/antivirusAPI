package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.UsuarioOportunidad;
import com.example.antivirusAPI.repository.UsuarioOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioOportunidadService {

    @Autowired
    private UsuarioOportunidadRepository usuarioOportunidadRepository;

    public List<UsuarioOportunidad> findAll() {
        return usuarioOportunidadRepository.findAll();
    }

    public Optional<UsuarioOportunidad> findById(Long id) {
        return usuarioOportunidadRepository.findById(id);
    }

    public UsuarioOportunidad save(UsuarioOportunidad usuarioOportunidad) {
        return usuarioOportunidadRepository.save(usuarioOportunidad);
    }

    public void deleteById(Long id) {
        usuarioOportunidadRepository.deleteById(id);
    }
}
