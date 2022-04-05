package com.example.springbootvalidation.annotation;

import com.example.springbootvalidation.validator.YearMonthValidator;

@javax.validation.Constraint(validatedBy = {YearMonthValidator.class})
@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE_USE})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface YearMonth {

    java.lang.String message() default "yyyyMM의 형식에 맞지 않습니다.";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};

    String pattern() default "yyyyMMdd";
}
