package com.example.integrationstudents.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
