package com.oliviak.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliviak.projectSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
