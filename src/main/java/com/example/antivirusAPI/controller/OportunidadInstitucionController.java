package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.OportunidadInstitucion;
import com.example.antivirusAPI.service.OportunidadInstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidad-instituciones")
public class OportunidadInstitucionController {

    @Autowired
    private OportunidadInstitucionService oportunidadInstitucionService;

    @GetMapping
    public List<OportunidadInstitucion> getAllOportunidadInstituciones() {
        return oportunidadInstitucionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OportunidadInstitucion> getOportunidadInstitucionById(@PathVariable Long id) {
        return oportunidadInstitucionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OportunidadInstitucion createOportunidadInstitucion(@RequestBody OportunidadInstitucion oportunidadInstitucion) {
        return oportunidadInstitucionService.save(oportunidadInstitucion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OportunidadInstitucion> updateOportunidadInstitucion(@PathVariable Long id, @RequestBody OportunidadInstitucion oportunidadInstitucionDetails) {
        return oportunidadInstitucionService.findById(id)
                .map(oportunidadInstitucion -> {
                    oportunidadInstitucion.setInstitucion(oportunidadInstitucionDetails.getInstitucion());
                    oportunidadInstitucion.setOportunidad(oportunidadInstitucionDetails.getOportunidad());
                    return ResponseEntity.ok(oportunidadInstitucionService.save(oportunidadInstitucion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOportunidadInstitucion(@PathVariable Long id) {
        return oportunidadInstitucionService.findById(id)
                .map(oportunidadInstitucion -> {
                    oportunidadInstitucionService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
