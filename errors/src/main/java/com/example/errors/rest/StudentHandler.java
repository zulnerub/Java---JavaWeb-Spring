package com.example.errors.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentHandler {

    @ExceptionHandler({StudentNotFoundException.class})
    public ResponseEntity<Error> handleStudentNotFoundException() {
        return ResponseEntity.ok(
                new Error()
                        .setErrorName("error name")
                        .setErrorDescription("error description"));
    }
}
