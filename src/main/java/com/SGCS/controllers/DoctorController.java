package com.SGCS.controllers;

import com.SGCS.Domain.Doctor;
import com.SGCS.Validation.ValidationUtil;
import com.SGCS.services.DoctorService;
import jakarta.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/v1/doctores")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> ListarDoctores(){
        return doctorService.listarDoctores();
    }

    @PostMapping
    public ResponseEntity<?> registrarDoctor(@Valid @RequestBody Doctor doctor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errores = ValidationUtil.getValidationErrors(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        } else {
            Doctor nuevoDoctor = doctorService.registrarDoctor(doctor);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDoctor);
        }
    }

}
