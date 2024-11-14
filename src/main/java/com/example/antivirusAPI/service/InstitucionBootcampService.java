package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.InstitucionBootcamp;
import com.example.antivirusAPI.repository.InstitucionBootcampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionBootcampService {

    @Autowired
    private InstitucionBootcampRepository institucionBootcampRepository;

    public List<InstitucionBootcamp> findAll() {
        return institucionBootcampRepository.findAll();
    }

    public Optional<InstitucionBootcamp> findById(Long id) {
        return institucionBootcampRepository.findById(id);
    }

    public InstitucionBootcamp save(InstitucionBootcamp institucionBootcamp) {
        return institucionBootcampRepository.save(institucionBootcamp);
    }

    public void deleteById(Long id) {
        institucionBootcampRepository.deleteById(id);
    }
}
