package com.syrisa.studentservice.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExceptionMessage {
    String message() default "Exception occurred";
}
