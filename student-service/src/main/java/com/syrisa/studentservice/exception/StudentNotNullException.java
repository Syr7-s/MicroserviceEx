package com.syrisa.studentservice.exception;

import com.syrisa.studentservice.annotation.ExceptionMessage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class StudentNotNullException extends Exception{
    @ExceptionMessage(message = "Student not null")
    public StudentNotNullException() throws NoSuchMethodException {
        Class<?> clazz = ExceptionMessage.class;
        Method method = clazz.getDeclaredMethod("message");
        String value = (String) method.getDefaultValue();
        NotNullException.getInstance(value);
    }
}
