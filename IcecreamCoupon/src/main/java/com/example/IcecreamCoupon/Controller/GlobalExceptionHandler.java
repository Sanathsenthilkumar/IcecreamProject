package com.example.IcecreamCoupon.Controller;

import com.example.IcecreamCoupon.Model.ErrorDetais;
import com.example.IcecreamCoupon.Util.CouponDiscountNotFoundException;
import com.example.IcecreamCoupon.Util.CouponIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import org.slf4j.Logger; // Add this import
import org.slf4j.LoggerFactory; // Add this import

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class); // Add this logger

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        logger.error("An unexpected error occurred in Coupon Service: ", new Date(), request.getDescription(false), ex); // ADD THIS LOGGING
        ErrorDetais errorDetais = new ErrorDetais(new Date(), "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorDetais, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CouponIdNotFoundException.class)
    public ResponseEntity<?> handleCouponIdNotFoundException(WebRequest request) {
        ErrorDetais errorDetais = new ErrorDetais(new Date(), "Coupon Not Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetais, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CouponDiscountNotFoundException.class)
    public ResponseEntity<?> handleCouponDiscountNotFoundException(WebRequest request) {
        ErrorDetais errorDetais = new ErrorDetais(new Date(), "Discount not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorDetais, HttpStatus.NOT_FOUND);
    }
}
