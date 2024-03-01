package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "administrativos")
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdministrativo;

    @Column(length = 255)
    private String nombre;

    @Column(length = 255)
    private String apellido;

    @Column(length = 255)
    private String cargo;
}
