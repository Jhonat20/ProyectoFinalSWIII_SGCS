package com.SGCS.services;

import com.SGCS.Domain.Cita;
import com.SGCS.Domain.Doctor;
import com.SGCS.Domain.Horario;
import com.SGCS.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor registrarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor modificarDoctor(Long idDoctor, Doctor doctor) {
        Doctor doctorEncontrado = doctorRepository.findById(idDoctor).orElse(null);
        if (doctorEncontrado != null) {
            doctorEncontrado.setNombre(doctor.getNombre());
            doctorEncontrado.setApellido(doctor.getApellido());
            doctorEncontrado.setEspecialidad(doctor.getEspecialidad());
            doctorEncontrado.setDni(doctor.getDni());
            doctorEncontrado.setTelefono(doctor.getTelefono());
            doctorEncontrado.setEmail(doctor.getEmail());
            return doctorRepository.save(doctorEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarDoctor(Long idDoctor) {
        doctorRepository.deleteById(idDoctor);
    }

    @Override
    public List<Doctor> listarDoctores() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor buscarDoctorPorId(Long idDoctor) {
        return doctorRepository.findById(idDoctor).orElse(null);
    }

    // Implementación de los métodos adicionales

    @Override
    public List<Doctor> buscarDoctoresPorEspecialidad(Long idEspecialidad) {
        return doctorRepository.findByEspecialidadId(idEspecialidad);
    }

    @Override
    public List<Doctor> buscarDoctoresPorNombre(String nombre) {
        return doctorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Horario obtenerHorarioDoctor(Long idDoctor) {
        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);
        return doctor != null ? doctor.getHorario() : null;
    }

    @Override
    public List<Cita> listarCitasDoctor(Long idDoctor) {
        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);
        return doctor != null ? (List<Cita>) doctor.getCitas() : new ArrayList<>();
    }
}

