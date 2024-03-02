package com.SGCS.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "doctores")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255, message = "El nombre debe tener como máximo 255 caracteres")
    @Column(length = 255, nullable = false)
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Size(max = 255, message = "Los apellidos deben tener como máximo 255 caracteres")
    @Column(length = 255, nullable = false)
    private String apellidos;

    @NotBlank(message = "El DNI es obligatorio")
    @Size(max = 20, message = "El DNI debe tener como máximo 20 caracteres")
    @Column(length = 20, nullable = false, unique = true)
    private String dni;

    @Size(max = 20, message = "El teléfono debe tener como máximo 20 caracteres")
    @Column(length = 20)
    private String telefono;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener un formato válido")
    @Size(max = 255, message = "El email debe tener como máximo 255 caracteres")
    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "doctor_especialidad",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private Set<Especialidad> especialidades = new HashSet<>();

}