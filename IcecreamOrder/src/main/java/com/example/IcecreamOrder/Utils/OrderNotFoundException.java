package com.example.IcecreamOrder.Utils;

public class OrderNotFoundException extends RuntimeException{

    private String message;

    public OrderNotFoundException(String message) {
        super(message);
    }

//    or this,
//    @Override
//    public String toString() {
//        return "Flavor not found";
//    }
}
