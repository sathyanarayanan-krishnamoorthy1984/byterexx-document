package com.byterexx.document.common.validator;

import com.byterexx.document.common.validator.service.DateFormatValidator;
import com.byterexx.document.common.constants.AppConstants;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
public @interface DateFormat {
    String message() default "Invalid date format.";
    String fieldName() default "";
    String format() default AppConstants.DATE_FORMAT_YYYYMMDD_HHMMSS;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

