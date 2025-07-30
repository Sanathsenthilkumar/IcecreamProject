package com.example.icecreamservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Icecream {

    @Id
    private int flavourId;
    private String flavourName;
    private String description;
    private int price;
    private boolean isAvailable;

    public Icecream(int flavourId, String flavourName, String description, int price, boolean isAvailable) {
        this.flavourId = flavourId;
        this.flavourName = flavourName;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getFlavourId() {
        return flavourId;
    }

    public void setFlavourId(int flavourId) {
        this.flavourId = flavourId;
    }

    public String getFlavourName() {
        return flavourName;
    }

    public void setFlavourName(String flavourName) {
        this.flavourName = flavourName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
