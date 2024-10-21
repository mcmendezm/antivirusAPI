package com.example.antivirusAPI.service;

import com.example.antivirusAPI.model.Bootcamp;
import com.example.antivirusAPI.repository.BootcampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BootcampService {

    @Autowired
    private BootcampRepository bootcampRepository;

    public List<Bootcamp> findAll() {
        return bootcampRepository.findAll();
    }

    public Optional<Bootcamp> findById(Long id) {
        return bootcampRepository.findById(id);
    }

    public Bootcamp save(Bootcamp bootcamp) {
        return bootcampRepository.save(bootcamp);
    }

    public void deleteById(Long id) {
        bootcampRepository.deleteById(id);
    }
}
