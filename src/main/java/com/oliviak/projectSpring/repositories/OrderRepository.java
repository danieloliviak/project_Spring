package com.oliviak.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliviak.projectSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
