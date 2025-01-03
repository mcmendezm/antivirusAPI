package com.example.antivirusAPI.repository;

import com.example.antivirusAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método adicional para buscar un usuario por correo
    //Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByUsername(String username);
}
