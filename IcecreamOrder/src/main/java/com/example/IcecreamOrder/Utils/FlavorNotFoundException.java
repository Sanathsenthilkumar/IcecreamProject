package com.example.IcecreamOrder.Utils;

public class FlavorNotFoundException extends RuntimeException {
    public FlavorNotFoundException(String message) {
        super(message);
    }
}
