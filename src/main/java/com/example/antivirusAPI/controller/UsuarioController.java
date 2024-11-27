package com.example.antivirusAPI.controller;
import org.springframework.util.StringUtils;
import org.springframework.http.HttpHeaders;
import com.example.antivirusAPI.Jwt.JwtService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import com.example.antivirusAPI.model.Usuario;
import com.example.antivirusAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Para codificar la contraseña

    @Autowired
    private JwtService jwtService; // Instancia de JwtService inyectada

    @Autowired
    private UserDetailsService userDetailsService; // Instancia de UserDetailsService inyectada


    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        System.out.println("aqui");
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioDetails.getNombre());
                    usuario.setCorreo(usuarioDetails.getCorreo());
                    usuario.setPassword(usuarioDetails.getPassword());
                    usuario.setRol(usuarioDetails.getRol());
                    usuario.setUsername(usuarioDetails.getUsername());
                    usuario.setFechaNacimiento(usuarioDetails.getFechaNacimiento());
                    return ResponseEntity.ok(usuarioService.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    usuarioService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/role")
    public ResponseEntity<?> getUserInfo(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        // Verificar si el encabezado contiene un token válido
        if (!StringUtils.hasText(authHeader) || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Encabezado de autorización inválido o faltante.");
        }

        // Extraer el token
        String token = authHeader.substring(7);

        // Usar la instancia de JwtService para obtener el nombre de usuario
        String username = jwtService.getUsernameFromToken(token);

        // Cargar los detalles del usuario usando UserDetailsService
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Construir respuesta personalizada
        Map<String, Object> response = new HashMap<>();
        response.put("username", userDetails.getUsername());

        // Asumimos que el rol está en el primer authority (ajusta según sea necesario)
        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("UNKNOWN");
        response.put("role", role);

        // Retornar los datos del usuario y su rol
        return ResponseEntity.ok(response);

}
}
