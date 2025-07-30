package com.example.icecreamservice.service;

import com.example.icecreamservice.model.Icecream;

import java.util.List;

public interface IcecreamService {

    public List<Icecream> getFlavours();
    public Icecream getFlavourById(int flavourId);
    public Icecream addFlavour(Icecream flavour);
}
