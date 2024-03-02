package com.SGCS.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
}



