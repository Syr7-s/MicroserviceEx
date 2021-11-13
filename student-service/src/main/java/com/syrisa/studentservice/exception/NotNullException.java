package com.syrisa.studentservice.exception;


public class NotNullException extends Exception {
    private static NotNullException instance = null;
    private static final Object LOCK = new Object();

    public static NotNullException getInstance(String message) {
        synchronized (LOCK) {
            return instance == null ? new NotNullException(message) : instance;
        }
    }

    private NotNullException(String message) {
        super(message);
    }

}
