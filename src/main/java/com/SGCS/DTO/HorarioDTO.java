package com.SGCS.DTO;

import lombok.Data;

import java.sql.Time;

@Data
public class HorarioDTO {
        private Long idHorario;

        private String nombreDoctor; // Asumiendo que se quiere mostrar el nombre del doctor

        private Time horaInicio;

        private Time horaFin;

        private String diaTrabjo;

        private boolean disponible;

}
