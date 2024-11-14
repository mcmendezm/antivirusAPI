package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.Institucion;
import com.example.antivirusAPI.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @GetMapping
    public List<Institucion> getAllInstituciones() {
        return institucionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institucion> getInstitucionById(@PathVariable Long id) {
        return institucionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Institucion createInstitucion(@RequestBody Institucion institucion) {
        return institucionService.save(institucion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institucion> updateInstitucion(@PathVariable Long id, @RequestBody Institucion institucionDetails) {
        return institucionService.findById(id)
                .map(institucion -> {
                    institucion.setNombre(institucionDetails.getNombre());
                    institucion.setUbicacion(institucionDetails.getUbicacion());
                    institucion.setUrlGeneralidades(institucionDetails.getUrlGeneralidades());
                    institucion.setUrlOfertaAcademica(institucionDetails.getUrlOfertaAcademica());
                    institucion.setUrlBienestar(institucionDetails.getUrlBienestar());
                    institucion.setUrlAdmision(institucionDetails.getUrlAdmision());
                    return ResponseEntity.ok(institucionService.save(institucion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitucion(@PathVariable Long id) {
        return institucionService.findById(id)
                .map(institucion -> {
                    institucionService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
