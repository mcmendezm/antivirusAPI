package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.InstitucionBootcamp;
import com.example.antivirusAPI.repository.InstitucionBootcampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionBootcampService {

    @Autowired
    private InstitucionBootcampRepository repository;

    public List<InstitucionBootcamp> getAll() {
        return repository.findAll();
    }

    public InstitucionBootcamp getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public InstitucionBootcamp save(InstitucionBootcamp institucionBootcamp) {
        return repository.save(institucionBootcamp);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
