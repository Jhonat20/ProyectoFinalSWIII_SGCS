package com.SGCS.repositories;

import com.SGCS.Domain.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EspecialidadRepository extends JpaRepository <Especialidad, Long> {

}
