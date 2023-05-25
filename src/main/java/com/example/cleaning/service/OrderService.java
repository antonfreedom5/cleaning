package com.example.cleaning.service;

import com.example.cleaning.entity.Order;
import com.example.cleaning.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(com.example.cleaning.repository.OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> getByClientId(Long id) {
        return this.orderRepository.findByClientId(id);
    }

    public Optional<Order> getByDriverId(Long id) {
        return this.orderRepository.findByDriverId(id);
    }

    public Optional<Order> getByStatusId(Long id) {
        return this.orderRepository.findByStatusId(id);
    }
}
