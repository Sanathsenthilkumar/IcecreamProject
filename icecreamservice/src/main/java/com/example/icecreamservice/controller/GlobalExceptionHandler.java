package com.example.icecreamservice.controller;

import com.example.icecreamservice.model.ErrorDetails;
import com.example.icecreamservice.util.FlavourNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(WebRequest request) {
        ErrorDetails errorDetais = new ErrorDetails(new Date(), "Internal Server Error", "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorDetais, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlavourNotFoundException.class)
    public ResponseEntity<?> handleFlavourNotFoundException(WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Flavour not found", "NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
