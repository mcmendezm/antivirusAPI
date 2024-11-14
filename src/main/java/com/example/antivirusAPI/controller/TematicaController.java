package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.Tematica;
import com.example.antivirusAPI.service.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tematicas")
public class TematicaController {

    @Autowired
    private TematicaService tematicaService;

    @GetMapping
    public List<Tematica> getAllTematicas() {
        return tematicaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tematica> getTematicaById(@PathVariable Long id) {
        return tematicaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tematica createTematica(@RequestBody Tematica tematica) {
        return tematicaService.save(tematica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tematica> updateTematica(@PathVariable Long id, @RequestBody Tematica tematicaDetails) {
        return tematicaService.findById(id)
                .map(tematica -> {
                    tematica.setNombre(tematicaDetails.getNombre());
                    return ResponseEntity.ok(tematicaService.save(tematica));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTematica(@PathVariable Long id) {
        return tematicaService.findById(id)
                .map(tematica -> {
                    tematicaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
