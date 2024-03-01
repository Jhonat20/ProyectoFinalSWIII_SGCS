package com.SGCS.exception;

public class ErrorMessage {
    public static final String HISTORIAL_MEDICO_NOT_FOUND = "El Historial Medico con id proporcionado no fue encontrado";


    private ErrorMessage() {
        throw new IllegalStateException ("Utility class");
    }
}
