package com.example.antivirusAPI.Auth;

import com.example.antivirusAPI.model.Usuario;
import jakarta.persistence.Column;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String correo;
    private String password;
    private String rol;
    private String username;
    private LocalDate fechaNacimiento;
}
