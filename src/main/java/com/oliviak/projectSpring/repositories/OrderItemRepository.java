package com.oliviak.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliviak.projectSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
