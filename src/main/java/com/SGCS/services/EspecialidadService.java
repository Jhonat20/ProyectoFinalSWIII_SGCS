package com.SGCS.services;
import com.SGCS.Domain.Especialidad;

import java.util.List;

public interface EspecialidadService {
        Especialidad registrarEspecialidad(Especialidad especialidad);
        Especialidad modificarEspecialidad(Long idEspecialidad, Especialidad especialidad);
        void eliminarEspecialidad(Long idEspecialidad);
        List<Especialidad> listarEspecialidades();
        Especialidad buscarEspecialidadPorId(Long idEspecialidad);

        // Métodos adicionales
        List<Especialidad> buscarEspecialidadesPorNombre(String nombre);
        List<Especialidad> buscarSubespecialidades(Long idEspecialidadPadre);

}
