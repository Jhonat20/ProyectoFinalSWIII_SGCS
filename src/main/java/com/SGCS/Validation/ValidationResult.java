package com.SGCS.Validation;

import jakarta.validation.ConstraintViolation;
import java.util.Set;

public record ValidationResult(Set<? extends ConstraintViolation<?>> violations) {
    public boolean isValid() {
        return violations.isEmpty();
    }
}
