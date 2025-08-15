package com.byterexx.document.common.validator.service;

import com.byterexx.document.common.validator.Base64;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Base64Validator implements ConstraintValidator<Base64, String> {

    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            java.util.Base64.getDecoder().decode(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
