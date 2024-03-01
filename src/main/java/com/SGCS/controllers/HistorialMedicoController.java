package com.SGCS.controllers;


import com.SGCS.Domain.HistorialMedico;
import com.SGCS.exception.ErrorResponse;
import com.SGCS.exception.IllegalOperationException;
import com.SGCS.services.HistorialMedicoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/HistrialMedico")
public class HistorialMedicoController {
 @Autowired
private HistorialMedicoService historialMedicoService;

 @GetMapping
public ResponseEntity<?> obtenerTodos() {
     try {
         List<HistorialMedico> historialMedico = historialMedicoService.listarTodos();
         if(historialMedico==null || historialMedico.isEmpty()) {
         	return ResponseEntity.noContent().build();
         }
         else return ResponseEntity.ok(historialMedico);
     } catch (Exception e) {
     	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error interno del servidor"));
     }
 }
@GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
     try {
         HistorialMedico historialMedico = historialMedicoService.buscarPorId(id);
         return ResponseEntity.ok(historialMedico);

     }catch (EntityNotFoundException e) {
     	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
     }catch (Exception e) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error interno del servidor"));
     }
 }

@PostMapping
public ResponseEntity<?> guardar(@RequestBody HistorialMedico historialMedico) {
     try {
         historialMedico = historialMedicoService.grabar(historialMedico);
         return ResponseEntity.status(HttpStatus.CREATED).body(historialMedico);
     } catch(IllegalOperationException e) {
     	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
     } catch (Exception e) {
     	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error interno del servidor"));
     }
 }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody HistorialMedico historialMedico) {
        try {
            historialMedico = historialMedicoService.actualizar(id, historialMedico);
            return ResponseEntity.ok(historialMedico);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
        } catch (IllegalOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error interno del servidor"));
        }
    }

}
