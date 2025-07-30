package com.example.icecreamservice.repository;

import com.example.icecreamservice.model.Icecream;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcecreamRepository extends MongoRepository<Icecream, Integer> {
}
