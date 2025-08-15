package com.byterexx.document.common.validator.service;

import com.byterexx.document.common.validator.DateFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {

    private String dateFormat;

    @Override
    public void initialize(DateFormat annotation) {
        dateFormat = annotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(dateFormat);
        if (StringUtils.isBlank(value)) {
            return true;
        }
        try {
            dateTimeFormat.parse(value);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}