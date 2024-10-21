package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.InstitucionBootcamp;
import com.example.antivirusAPI.service.InstitucionBootcampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institucion-bootcamps")
public class InstitucionBootcampController {

    @Autowired
    private InstitucionBootcampService service;

    @GetMapping
    public List<InstitucionBootcamp> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitucionBootcamp> getById(@PathVariable Long id) {
        InstitucionBootcamp ib = service.getById(id);
        return ib != null ? ResponseEntity.ok(ib) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public InstitucionBootcamp create(@RequestBody InstitucionBootcamp ib) {
        return service.save(ib);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitucionBootcamp> update(@PathVariable Long id, @RequestBody InstitucionBootcamp ib) {
        if (service.getById(id) != null) {
            ib.setId(id);
            return ResponseEntity.ok(service.save(ib));
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
