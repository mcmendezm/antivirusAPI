package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.Oportunidad;
import com.example.antivirusAPI.service.OportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadController {

    @Autowired
    private OportunidadService oportunidadService;

    @GetMapping
    public List<Oportunidad> getAllOportunidades() {
        return oportunidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidad> getOportunidadById(@PathVariable Long id) {
        return oportunidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Oportunidad createOportunidad(@RequestBody Oportunidad oportunidad) {
        return oportunidadService.save(oportunidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oportunidad> updateOportunidad(@PathVariable Long id, @RequestBody Oportunidad oportunidadDetails) {
        return oportunidadService.findById(id)
                .map(oportunidad -> {
                    oportunidad.setNombre(oportunidadDetails.getNombre());
                    oportunidad.setObservaciones(oportunidadDetails.getObservaciones());
                    oportunidad.setTipo(oportunidadDetails.getTipo());
                    oportunidad.setDescripcion(oportunidadDetails.getDescripcion());
                    oportunidad.setRequisitos(oportunidadDetails.getRequisitos());
                    oportunidad.setGuia(oportunidadDetails.getGuia());
                    oportunidad.setDatosAdicionales(oportunidadDetails.getDatosAdicionales());
                    oportunidad.setCanalesAtencion(oportunidadDetails.getCanalesAtencion());
                    oportunidad.setEncargado(oportunidadDetails.getEncargado());
                    oportunidad.setModalidad(oportunidadDetails.getModalidad());
                    oportunidad.setCategoria(oportunidadDetails.getCategoria());
                    oportunidad.setInstitucion(oportunidadDetails.getInstitucion());
                    return ResponseEntity.ok(oportunidadService.save(oportunidad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOportunidad(@PathVariable Long id) {
        return oportunidadService.findById(id)
                .map(oportunidad -> {
                    oportunidadService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build(); // Corrección aquí
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
