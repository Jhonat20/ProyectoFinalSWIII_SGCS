package com.SGCS.DTO;

import com.SGCS.Domain.Cita;
import com.SGCS.Domain.Especialidad;
import com.SGCS.Domain.Horario;
import lombok.Data;

import java.util.Set;

@Data
public class DoctorDTO {
    private Long idDoctor;
    private String nombre;
    private String apellido;
    private Especialidad especialidad;
    private String dni;
    private String telefono;
    private String email;
    private Horario horario;
    private Set<Cita> citas;
}
