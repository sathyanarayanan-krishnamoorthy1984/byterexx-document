package com.byterexx.document.common.validator;

import com.byterexx.document.common.validator.service.Base64Validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Base64Validator.class)
@Repeatable(Base64.List.class)
public @interface Base64 {
    String message() default "Invalid Field Value.";
    String fieldName() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface List {
    Base64[] value();
  }
}