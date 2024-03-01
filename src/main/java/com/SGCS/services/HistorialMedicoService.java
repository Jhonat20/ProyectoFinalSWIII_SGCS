package com.SGCS.services;

import com.SGCS.Domain.HistorialMedico;
import com.SGCS.exception.IllegalOperationException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface HistorialMedicoService {
List<HistorialMedico> listarTodos();
HistorialMedico buscarPorId(Long id)throws EntityNotFoundException;
HistorialMedico grabar(HistorialMedico historialMedico) throws IllegalOperationException;

HistorialMedico actualizar(Long id, HistorialMedico historialMedico) throws EntityNotFoundException, IllegalOperationException;
void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;

}
