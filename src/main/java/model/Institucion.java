package com.example.antivirusAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instituciones")
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String ubicacion;

    @Column(length = 1000)
    private String urlGeneralidades;

    @Column(length = 1000)
    private String urlOfertaAcademica;

    @Column(length = 1000)
    private String urlBienestar;

    @Column(length = 1000)
    private String urlAdmision;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrlGeneralidades() {
        return urlGeneralidades;
    }

    public void setUrlGeneralidades(String urlGeneralidades) {
        this.urlGeneralidades = urlGeneralidades;
    }

    public String getUrlOfertaAcademica() {
        return urlOfertaAcademica;
    }

    public void setUrlOfertaAcademica(String urlOfertaAcademica) {
        this.urlOfertaAcademica = urlOfertaAcademica;
    }

    public String getUrlBienestar() {
        return urlBienestar;
    }

    public void setUrlBienestar(String urlBienestar) {
        this.urlBienestar = urlBienestar;
    }

    public String getUrlAdmision() {
        return urlAdmision;
    }

    public void setUrlAdmision(String urlAdmision) {
        this.urlAdmision = urlAdmision;
    }
}
