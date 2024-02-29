package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Data
@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @OneToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    @Column(length = 255)
    private String diasTrabajo;

    @Column
    private Time horasEntrada;

    @Column
    private Time horasSalida;
}
