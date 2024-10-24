package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.OportunidadInstitucion;
import com.example.antivirusAPI.repository.OportunidadInstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadInstitucionService {

    @Autowired
    private OportunidadInstitucionRepository oportunidadInstitucionRepository;

    public List<OportunidadInstitucion> findAll() {
        return oportunidadInstitucionRepository.findAll();
    }

    public Optional<OportunidadInstitucion> findById(Long id) {
        return oportunidadInstitucionRepository.findById(id);
    }

    public OportunidadInstitucion save(OportunidadInstitucion oportunidadInstitucion) {
        return oportunidadInstitucionRepository.save(oportunidadInstitucion);
    }

    public void deleteById(Long id) {
        oportunidadInstitucionRepository.deleteById(id);
    }
}
