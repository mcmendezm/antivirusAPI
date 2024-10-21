package com.example.antivirusAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bootcamps_tematicas")
public class BootcampTematica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_bootcamps", nullable = false)
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "id_tematicas", nullable = false)
    private Tematica tematica;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
}
