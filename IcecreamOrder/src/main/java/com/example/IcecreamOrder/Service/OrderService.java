package com.example.IcecreamOrder.Service;

import com.example.IcecreamOrder.Model.Order;
import com.example.IcecreamOrder.Repository.OrderRepository;

import java.util.List;

public interface OrderService {
    abstract List<Order> getOrders();
    abstract Order getOrderById(int id);
    abstract Order getOrderByFlavorId(int flavorId);
    abstract void updateOrderById(Order order);
    abstract void newOrder(Order order);
    abstract Order deleteOrderById(int id);
    abstract Order getOrderByFlavorName(String flavorName);
}
