package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "historiales_medicos")
public class HistorialMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial;

    @OneToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @Column(columnDefinition = "TEXT")
    private String alergias;

    @Column(columnDefinition = "TEXT")
    private String enfermedadesPrevias;

    @Column(columnDefinition = "TEXT")
    private String cirugias;

    @Column(columnDefinition = "TEXT")
    private String medicacionHabitual;


}
