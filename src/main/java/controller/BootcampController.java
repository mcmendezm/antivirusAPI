package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.Bootcamp;
import com.example.antivirusAPI.service.BootcampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {

    @Autowired
    private BootcampService bootcampService;

    @GetMapping
    public List<Bootcamp> getAllBootcamps() {
        return bootcampService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamp> getBootcampById(@PathVariable Long id) {
        return bootcampService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bootcamp createBootcamp(@RequestBody Bootcamp bootcamp) {
        return bootcampService.save(bootcamp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bootcamp> updateBootcamp(@PathVariable Long id, @RequestBody Bootcamp bootcampDetails) {
        return bootcampService.findById(id)
                .map(bootcamp -> {
                    bootcamp.setDescripcion(bootcampDetails.getDescripcion());
                    bootcamp.setInformacion(bootcampDetails.getInformacion());
                    bootcamp.setCostos(bootcampDetails.getCostos());
                    bootcamp.setNombre(bootcampDetails.getNombre());
                    bootcamp.setInstitucion(bootcampDetails.getInstitucion());
                    return ResponseEntity.ok(bootcampService.save(bootcamp));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcamp(@PathVariable Long id) {
        return bootcampService.findById(id)
                .map(bootcamp -> {
                    bootcampService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
