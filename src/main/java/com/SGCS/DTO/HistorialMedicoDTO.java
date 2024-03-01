package com.SGCS.DTO;

import com.SGCS.Domain.Paciente;
import lombok.Data;

@Data
public class HistorialMedicoDTO {
private  Long idHistorial;
private Paciente paciente;
private String alergias;
private String enfermedadesPrevias;
private String cirugias;
private String medicacionHabitual;

}
