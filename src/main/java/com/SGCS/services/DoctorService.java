package com.SGCS.services;

import com.SGCS.Domain.Cita;
import com.SGCS.Domain.Doctor;
import com.SGCS.Domain.Horario;

import java.util.List;

public interface DoctorService {
        // Métodos CRUD
        Doctor registrarDoctor(Doctor doctor);
        Doctor modificarDoctor(Long idDoctor, Doctor doctor);
        void eliminarDoctor(Long idDoctor);
        List<Doctor> listarDoctores();
        Doctor buscarDoctorPorId(Long idDoctor);

        // Métodos adicionales
        List<Doctor> buscarDoctoresPorEspecialidad(Long idEspecialidad);
        List<Doctor> buscarDoctoresPorNombre(String nombre);
        Horario obtenerHorarioDoctor(Long idDoctor);
        List<Cita> listarCitasDoctor(Long idDoctor);

}
