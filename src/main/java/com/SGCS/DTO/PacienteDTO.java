package com.SGCS.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PacienteDTO {
        private Long idPaciente;

        private String nombre;

        private String apellido;

        private String dni;

        private Date fechaNacimiento;

        private String genero;

        private String direccion;

        private String telefono;

        private String email;

}
