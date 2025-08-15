package com.byterexx.document.common.validator.service;

import com.byterexx.document.common.validator.LocaleValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class LocaleValidator implements ConstraintValidator<LocaleValid, String> {

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraint) {
        if (StringUtils.isBlank(value)) {
            return true;
        }
        try {
            Locale locale = Locale.forLanguageTag(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
