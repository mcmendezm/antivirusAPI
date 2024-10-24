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
    private InstitucionBootcampService institucionBootcampService;

    @GetMapping
    public List<InstitucionBootcamp> getAllInstitucionBootcamps() {
        return institucionBootcampService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstitucionBootcamp> getInstitucionBootcampById(@PathVariable Long id) {
        return institucionBootcampService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InstitucionBootcamp createInstitucionBootcamp(@RequestBody InstitucionBootcamp institucionBootcamp) {
        return institucionBootcampService.save(institucionBootcamp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstitucionBootcamp> updateInstitucionBootcamp(@PathVariable Long id, @RequestBody InstitucionBootcamp institucionBootcampDetails) {
        return institucionBootcampService.findById(id)
                .map(institucionBootcamp -> {
                    institucionBootcamp.setInstitucion(institucionBootcampDetails.getInstitucion());
                    institucionBootcamp.setBootcamp(institucionBootcampDetails.getBootcamp());
                    return ResponseEntity.ok(institucionBootcampService.save(institucionBootcamp));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucionBootcamp(@PathVariable Long id) {
        return institucionBootcampService.findById(id)
                .map(institucionBootcamp -> {
                    institucionBootcampService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
