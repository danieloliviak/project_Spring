package com.oliviak.projectSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.oliviak.projectSpring.entities.Category;
import com.oliviak.projectSpring.entities.Order;
import com.oliviak.projectSpring.entities.Product;
import com.oliviak.projectSpring.entities.User;
import com.oliviak.projectSpring.entities.enums.OrderStatus;
import com.oliviak.projectSpring.repositories.CategoryRepository;
import com.oliviak.projectSpring.repositories.OrderRepository;
import com.oliviak.projectSpring.repositories.ProductRepository;
import com.oliviak.projectSpring.repositories.UserRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository category;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        User u1 = new User(null, "daniel", "daniel@gmail.com", "999999769", "123456");
        User u2 = new User(null, "oliviak", "oliviak@gmail.com", "999999943", "123456");
        User u3 = new User(null, "pinto", "pinto@gmail.com", "999999129", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Order o1 = new Order(null, Instant.parse("2023-03-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2023-06-12T20:44:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2023-10-26T13:31:22Z"), OrderStatus.PAID, u3);
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Lorem ipsum dolor sit amet", 2190.0, "");
        category.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        productRepository.saveAll(Arrays.asList(p1, p2));

    }
}
