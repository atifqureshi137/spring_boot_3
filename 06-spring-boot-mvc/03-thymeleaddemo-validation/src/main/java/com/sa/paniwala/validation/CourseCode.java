package com.sa.paniwala.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	 public String value() default "PANI";
	 public String message() default "Must start with PANI";
	 
	 // define default group
	 public Class<?>[] groups() default{};
	 // define default payloads
	 public Class<? extends Payload>[] payload() default{};
}
