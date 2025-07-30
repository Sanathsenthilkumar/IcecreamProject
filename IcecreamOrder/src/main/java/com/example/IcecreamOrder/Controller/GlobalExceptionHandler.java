package com.example.IcecreamOrder.Controller;

import com.example.IcecreamOrder.Model.ErrorDetails;
import com.example.IcecreamOrder.Utils.FlavorNotFoundException;
import com.example.IcecreamOrder.Utils.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Order not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FlavorNotFoundException.class)
    public ResponseEntity<?> handleFlavorNotFoundException(WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Flavor not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
