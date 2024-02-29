package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity

public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(length = 255, nullable = false)
    private String nombre;

    @Column(length = 255, nullable = false)
    private String apellido;

    @Column(length = 20, unique = true, nullable = false)
    private String dni;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(length = 10)
    private String genero;

    @Column(length = 500)
    private String direccion;

    @Column(length = 20)
    private String telefono;

    @Column(length = 255)
    private String email;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;
}
