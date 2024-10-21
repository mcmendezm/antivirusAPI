package com.example.antivirusAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "oportunidades")
public class Oportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 1000)
    private String observaciones;

    @Column(nullable = false)
    private String tipo;

    @Column(length = 1000)
    private String descripcion;

    @Column(length = 1000)
    private String requisitos;

    @Column(length = 1000)
    private String guia;

    @Column(name = "datos_adicionales", length = 1000)
    private String datosAdicionales;

    @Column(name = "canales_atencion", length = 500)
    private String canalesAtencion;

    @Column(length = 255)
    private String encargado;

    @Column(length = 100)
    private String modalidad;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = true)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_institucion", nullable = true)
    private Institucion institucion;

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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getDatosAdicionales() {
        return datosAdicionales;
    }

    public void setDatosAdicionales(String datosAdicionales) {
        this.datosAdicionales = datosAdicionales;
    }

    public String getCanalesAtencion() {
        return canalesAtencion;
    }

    public void setCanalesAtencion(String canalesAtencion) {
        this.canalesAtencion = canalesAtencion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
