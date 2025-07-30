package com.example.icecreamservice.service;

import com.example.icecreamservice.model.Icecream;
import com.example.icecreamservice.repository.IcecreamRepository;
import com.example.icecreamservice.util.FlavourNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IcecreamServiceImpl implements IcecreamService {

    @Autowired
    private IcecreamRepository icecreamRepository;

    @Override
    public List<Icecream> getFlavours() {
        return icecreamRepository.findAll();
    }

    @Override
    public Icecream getFlavourById(int flavourId) {
        Optional<Icecream> _flavour = icecreamRepository.findById(flavourId);
        if(_flavour.isPresent()) {
            Icecream flavour = _flavour.get();
            return flavour;
        } else {
            throw new FlavourNotFoundException("flavour not found "+ flavourId);
        }
    }

    @Override
    public Icecream addFlavour(Icecream flavour) {
        icecreamRepository.save(flavour);
        return flavour;
    }
}
