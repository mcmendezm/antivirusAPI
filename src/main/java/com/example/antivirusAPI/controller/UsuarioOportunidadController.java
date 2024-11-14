package com.example.antivirusAPI.controller;

import com.example.antivirusAPI.model.UsuarioOportunidad;
import com.example.antivirusAPI.service.UsuarioOportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-oportunidades")
public class UsuarioOportunidadController {

    @Autowired
    private UsuarioOportunidadService usuarioOportunidadService;

    @GetMapping
    public List<UsuarioOportunidad> getAllUsuarioOportunidades() {
        return usuarioOportunidadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOportunidad> getUsuarioOportunidadById(@PathVariable Long id) {
        return usuarioOportunidadService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioOportunidad createUsuarioOportunidad(@RequestBody UsuarioOportunidad usuarioOportunidad) {
        return usuarioOportunidadService.save(usuarioOportunidad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioOportunidad> updateUsuarioOportunidad(@PathVariable Long id, @RequestBody UsuarioOportunidad usuarioOportunidadDetails) {
        return usuarioOportunidadService.findById(id)
                .map(usuarioOportunidad -> {
                    usuarioOportunidad.setUsuario(usuarioOportunidadDetails.getUsuario());
                    usuarioOportunidad.setOportunidad(usuarioOportunidadDetails.getOportunidad());
                    return ResponseEntity.ok(usuarioOportunidadService.save(usuarioOportunidad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioOportunidad(@PathVariable Long id) {
        return usuarioOportunidadService.findById(id)
                .map(usuarioOportunidad -> {
                    usuarioOportunidadService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
