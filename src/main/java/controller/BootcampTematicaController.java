package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.BootcampTematica;
import com.example.antivirusAPI.service.BootcampTematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamp-tematicas")
public class BootcampTematicaController {

    @Autowired
    private BootcampTematicaService bootcampTematicaService;

    @GetMapping
    public List<BootcampTematica> getAllBootcampTematicas() {
        return bootcampTematicaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BootcampTematica> getBootcampTematicaById(@PathVariable Long id) {
        return bootcampTematicaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BootcampTematica createBootcampTematica(@RequestBody BootcampTematica bootcampTematica) {
        return bootcampTematicaService.save(bootcampTematica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BootcampTematica> updateBootcampTematica(@PathVariable Long id, @RequestBody BootcampTematica bootcampTematicaDetails) {
        return bootcampTematicaService.findById(id)
                .map(bootcampTematica -> {
                    bootcampTematica.setBootcamp(bootcampTematicaDetails.getBootcamp());
                    bootcampTematica.setTematica(bootcampTematicaDetails.getTematica());
                    return ResponseEntity.ok(bootcampTematicaService.save(bootcampTematica));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcampTematica(@PathVariable Long id) {
        return bootcampTematicaService.findById(id)
                .map(bootcampTematica -> {
                    bootcampTematicaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
