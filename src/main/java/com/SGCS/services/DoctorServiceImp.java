package com.SGCS.services;

import com.SGCS.Domain.Cita;
import com.SGCS.Domain.Doctor;
import com.SGCS.Domain.Horario;
import com.SGCS.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImp implements DoctorService {

    @Autowired
    public DoctorRepository doctorRepository;

    @Override
    public Doctor registrarDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor modificarDoctor(Long idDoctor, Doctor doctor) {
        Doctor doctorEncontrado = doctorRepository.findById(idDoctor).orElse(null);
        if (doctorEncontrado != null) {
            doctorEncontrado.setNombre(doctor.getNombre());
            doctorEncontrado.setApellidos(doctor.getApellidos());
            //doctorEncontrado.setEspecialidad(doctor.getEspecialidad());
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


}

