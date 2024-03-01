package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "administrativos")
public class Administrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdministrativo;

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

    @Column(length = 255, nullable = false)
    private String cargo;

    @Column(length = 255)
    private String departamento;

}
