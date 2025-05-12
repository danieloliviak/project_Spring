package com.oliviak.projectSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviak.projectSpring.entities.Order;
import com.oliviak.projectSpring.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById(Long id) {
        Order obj = repository.findById(id).get();
        return obj;
    }
}
