package com.example.IcecreamOrder.Repository;

import com.example.IcecreamOrder.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
    Optional<Order> findByFlavourId(int flavourId);

    Optional<Order> findByFlavourName(String flavourName);
}
