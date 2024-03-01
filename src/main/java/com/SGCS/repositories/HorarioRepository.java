package com.SGCS.repositories;

import com.SGCS.Domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository <Horario, Long> {
}
