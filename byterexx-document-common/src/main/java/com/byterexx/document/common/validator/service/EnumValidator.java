package com.byterexx.document.common.validator.service;

import com.byterexx.document.common.validator.EnumValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnumValidator implements ConstraintValidator<EnumValid, String> {
    private Set<String> availableEnum;
    private boolean failOnEmpty;

    @Override
    public void initialize(final EnumValid enumValid) {
        final Class<? extends Enum<?>> enumSelected = enumValid.enumClass();
        failOnEmpty = enumValid.failOnEmpty();
        availableEnum = getNamesSet(enumSelected);
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraint) {
        boolean result = false;
        if (failOnEmpty && StringUtils.isWhitespace(value)) {
            return false;
        } else if (StringUtils.isEmpty(value)) {
            result = true;
        } else {
            result = availableEnum.contains(value);
        }
        return result;
    }

    public static Set<String> getNamesSet(final Class<? extends Enum<?>> selectedEnum) {
        final Enum<?>[] enums = selectedEnum.getEnumConstants();
        String[] names = new String[enums.length];
        for (int i = 0; i < enums.length; i++) {
            names[i] = enums[i].name().toUpperCase();
        }
        return new HashSet<>(Arrays.asList(names));
    }

}
