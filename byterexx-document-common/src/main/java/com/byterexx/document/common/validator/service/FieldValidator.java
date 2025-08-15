package com.byterexx.document.common.validator.service;

import jakarta.validation.*;

import java.util.Set;

public class FieldValidator { // no usages

    private Validator validator; // 2 usages

    public FieldValidator() { init(); }

    private void init() { // 1 usage
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public <T> void validate(T input) { // no usages
        Set<ConstraintViolation<T>> violations = validator.validate(input);
        if(violations!=null && !violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
