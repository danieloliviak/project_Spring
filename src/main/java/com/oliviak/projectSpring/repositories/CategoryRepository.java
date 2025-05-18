package com.oliviak.projectSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oliviak.projectSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
