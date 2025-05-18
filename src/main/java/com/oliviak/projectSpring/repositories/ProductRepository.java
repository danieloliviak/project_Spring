package com.oliviak.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oliviak.projectSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
