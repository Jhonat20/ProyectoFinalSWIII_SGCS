package com.SGCS.DTO;

import com.SGCS.Domain.Especialidad;
import lombok.Data;

import java.util.List;

@Data

public class EspecialidadDTO {

    private Long idEspecialidad;

    private String nombre;

    private String descripcion;

    private Especialidad idEspecialidadPadre;

    private List<EspecialidadDTO> subespecialidades;

}
