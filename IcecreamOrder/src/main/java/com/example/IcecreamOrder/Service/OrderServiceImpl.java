package com.example.IcecreamOrder.Service;

import com.example.IcecreamOrder.Model.Order;
import com.example.IcecreamOrder.Repository.OrderRepository;
import com.example.IcecreamOrder.Utils.FlavorNotFoundException;
import com.example.IcecreamOrder.Utils.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        Optional<Order> _getOrder= orderRepository.findById(id);
        if(_getOrder.isPresent()) {
            Order order = _getOrder.get();
            return order;
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }

    @Override
    public Order getOrderByFlavorId(int flavourId) {
        Optional<Order> _getOrder= orderRepository.findByFlavourId(flavourId);
        if(_getOrder.isPresent()) {
            Order order = _getOrder.get();
            return order;
        } else {
            throw new FlavorNotFoundException("Order not found");
        }
    }

    @Override
    public Order getOrderByFlavorName(String flavourName) {
        Optional<Order> _getOrder = orderRepository.findByFlavourName(flavourName);
        if(_getOrder.isPresent()) {
            Order order = _getOrder.get();
            return order;
        } else {
            throw new FlavorNotFoundException(flavourName+" is not available");
        }
    }

    @Override
    public void updateOrderById(Order order) {
        Optional<Order> _updateOrder = orderRepository.findById(order.getOrderId());
        if(_updateOrder.isPresent()) {
            Order newOrder = _updateOrder.get();
            newOrder.setFlavourId(order.getFlavourId());
            newOrder.setFlavourName(order.getFlavourName());
            newOrder.setPrice(order.getPrice());
            orderRepository.save(newOrder);
        } else {
            throw new OrderNotFoundException("Order with "+ order.getOrderId()+" id not found!");
        }
    }

    @Override
    public void newOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order deleteOrderById(int id) {
        Optional<Order> _order = orderRepository.findById(id);
        if(_order.isPresent()) {
            Order deletedOrder = _order.get();
            orderRepository.delete(deletedOrder);
            return deletedOrder;
        } else {
            throw new OrderNotFoundException("Order with "+ id +" id not found");
        }
    }
}
