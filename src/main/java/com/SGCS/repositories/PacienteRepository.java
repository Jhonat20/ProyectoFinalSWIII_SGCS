package com.SGCS.repositories;

import com.SGCS.Domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {

}
