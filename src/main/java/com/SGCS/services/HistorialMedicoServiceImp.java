package com.SGCS.services;

import com.SGCS.Domain.HistorialMedico;
import com.SGCS.exception.ErrorMessage;
import com.SGCS.exception.IllegalOperationException;
import com.SGCS.repositories.HistorialMedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialMedicoServiceImp implements HistorialMedicoService{

    @Autowired
    private HistorialMedicoRepository historialMedicoRepository;
    @Override
    @Transactional
    public List<HistorialMedico> listarTodos() {
        return  historialMedicoRepository.findAll();
    }

    /**
     * Devuelve todos los departamentos que hay en la base de datos.
     *
     * @return Lista de entidades de tipo departamento.
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public HistorialMedico buscarPorId(Long id) throws EntityNotFoundException {
        Optional<HistorialMedico> historialMedico = historialMedicoRepository.findById(id);
        if(historialMedico.isEmpty())throw new EntityNotFoundException(ErrorMessage.HISTORIAL_MEDICO_NOT_FOUND);
        return historialMedico.get();

    }

    /**
     * Guardar un nuevo departamento
     *
     //	 * @param Objeto del tipo Departamento que se va a persistir.
     * @return El objeto luego de persistirlo
     * @throws IllegalOperationException Si el nombre del departamento es inválido o
     * ya existe en la persistencia
     *
     */
    @Override
    @Transactional
    public HistorialMedico grabar(HistorialMedico historialMedico) throws IllegalOperationException {
        if(historialMedico.getDescripcion().isBlank()) {
            throw new IllegalOperationException("La descripcion del historial medico no debe estar en blanco");
        }
        return historialMedicoRepository.save(historialMedico);
    }

    @Override
    public HistorialMedico actualizar(Long id, HistorialMedico historialMedico) throws EntityNotFoundException, IllegalOperationException {
Optional<HistorialMedico> historialMedicoEntity = historialMedicoRepository.findById(id);
if(historialMedicoEntity.isEmpty())
    throw new EntityNotFoundException(ErrorMessage.HISTORIAL_MEDICO_NOT_FOUND);
if(historialMedico.getDescripcion().isBlank()) {
throw  new IllegalOperationException("La descripcion del historial medico no debe estar en blanco");
}
historialMedico.setIdHistorial(id);
return historialMedicoRepository.save(historialMedico);
    }

    @Override
    public void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException {
Optional<HistorialMedico> historialMedicoEntity = historialMedicoRepository.findById(id);
if(historialMedicoEntity.isEmpty())
    throw new EntityNotFoundException(ErrorMessage.HISTORIAL_MEDICO_NOT_FOUND);
if (!historialMedicoEntity.get().getPaciente().getNombre().isBlank()) {

    throw new IllegalOperationException("No se puede eliminar, el historial medico esta asignado a un paciente");
    }
    historialMedicoRepository.deleteById(id);
    }
}

