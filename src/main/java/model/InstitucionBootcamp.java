package com.example.antivirusAPI.model;


import jakarta.persistence.*;

@Entity
@Table(name = "institucion_bootcamps")
public class InstitucionBootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_instituciones", nullable = false)
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "id_bootcamps", nullable = false)
    private Bootcamp bootcamp;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }
}
