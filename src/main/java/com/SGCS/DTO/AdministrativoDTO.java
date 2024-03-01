package com.SGCS.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AdministrativoDTO {

        private Long idAdministrativo;

        private String nombre;

        private String apellido;

        private String dni;

        private Date fechaNacimiento;

        private String genero;

        private String direccion;

        private String telefono;

        private String email;

        private String cargo;

        private String departamento;
}
