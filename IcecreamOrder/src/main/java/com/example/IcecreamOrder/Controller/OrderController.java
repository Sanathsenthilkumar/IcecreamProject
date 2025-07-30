package com.example.IcecreamOrder.Controller;

import com.example.IcecreamOrder.Model.Order;
import com.example.IcecreamOrder.Service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> getOrders() {
        List<Order> _getOrders = orderServiceImpl.getOrders();
        return new ResponseEntity<>(_getOrders, HttpStatus.OK);
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order _getOrder = orderServiceImpl.getOrderById(id);
        return new ResponseEntity<>(_getOrder, HttpStatus.OK);
    }
    @GetMapping("/getOrderByFlavourId/{flavourId}")
    public ResponseEntity<Order> getOrderByFlavourId(@PathVariable int flavourId) {
        Order _getOrder = orderServiceImpl.getOrderByFlavorId(flavourId);
        return new ResponseEntity<>(_getOrder, HttpStatus.OK);
    }

    @GetMapping("/getOrderByFlavourName/{flavourName}")
    public ResponseEntity<Order> getOrderByFlavourName(@PathVariable String flavourName) {
        Order _getOrder = orderServiceImpl.getOrderByFlavorName(flavourName);
        return new ResponseEntity<>(_getOrder, HttpStatus.OK);
    }

    @PostMapping("/newOrder")
    public ResponseEntity<Void> newOrder(@RequestBody Order order) {
        orderServiceImpl.newOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Void> updateOrderById(@RequestBody Order order) {
        orderServiceImpl.updateOrderById(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable int id) {
        orderServiceImpl.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
