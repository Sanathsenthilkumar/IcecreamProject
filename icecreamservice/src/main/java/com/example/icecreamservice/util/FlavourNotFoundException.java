package com.example.icecreamservice.util;

public class FlavourNotFoundException extends RuntimeException {
    public FlavourNotFoundException(String message) {
        super(message);
    }
}
