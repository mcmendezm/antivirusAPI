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
    private BootcampTematicaService service;

    @GetMapping
    public List<BootcampTematica> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BootcampTematica> getById(@PathVariable Long id) {
        BootcampTematica bt = service.getById(id);
        return bt != null ? ResponseEntity.ok(bt) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public BootcampTematica create(@RequestBody BootcampTematica bt) {
        return service.save(bt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BootcampTematica> update(@PathVariable Long id, @RequestBody BootcampTematica bt) {
        if (service.getById(id) != null) {
            bt.setId(id);
            return ResponseEntity.ok(service.save(bt));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id) != null) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
