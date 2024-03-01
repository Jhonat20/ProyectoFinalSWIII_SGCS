package com.SGCS.DTO;

import lombok.Data;

@Data
public class DoctorDTO {
    private String nombre;
    private String apellidos;
    private EspecialidadDTO especialidad;
    private String dni;
    private String telefono;
    private String email;
}
