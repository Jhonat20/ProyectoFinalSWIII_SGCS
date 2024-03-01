package com.SGCS.repositories;

import com.SGCS.Domain.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialMedicoRepository extends JpaRepository <HistorialMedico, Long> {

}
