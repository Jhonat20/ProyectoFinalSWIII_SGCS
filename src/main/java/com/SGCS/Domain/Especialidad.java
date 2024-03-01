package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "especialidades")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long especialidadId;

    @Column(length = 255, nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    //@ManyToOne
    @JoinColumn(name = "especialidadPadreId")
    private Especialidad especialidadPadre;

   // @OneToMany(mappedBy = "especialidadPadre", cascade = CascadeType.ALL)
    private Set<Especialidad> subespecialidades;

    @ManyToMany(mappedBy = "especialidades")
    private Set<Doctor> doctores = new HashSet<>();

}
