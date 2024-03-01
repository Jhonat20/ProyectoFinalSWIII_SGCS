package com.SGCS.services;

import com.SGCS.Domain.Especialidad;
import com.SGCS.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImp implements EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad modificarEspecialidad(Long idEspecialidad, Especialidad especialidad) {
        Especialidad especialidadEncontrada = especialidadRepository.findById(idEspecialidad).orElse(null);
        if (especialidadEncontrada != null) {
            especialidadEncontrada.setNombre(especialidad.getNombre());
            especialidadEncontrada.setDescripcion(especialidad.getDescripcion());
            especialidadEncontrada.setEspecialidadPadre(especialidad.getEspecialidadPadre());
            return especialidadRepository.save(especialidadEncontrada);
        }
        return null;
    }

    @Override
    public void eliminarEspecialidad(Long idEspecialidad) {
        especialidadRepository.deleteById(idEspecialidad);
    }

    @Override
    public List<Especialidad> listarEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad buscarEspecialidadPorId(Long idEspecialidad) {
        return especialidadRepository.findById(idEspecialidad).orElse(null);
    }

}
