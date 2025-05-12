package com.oliviak.projectSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.oliviak.projectSpring.entities.Order;
import com.oliviak.projectSpring.entities.User;
import com.oliviak.projectSpring.repositories.OrderRepository;
import com.oliviak.projectSpring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "daniel", "daniel@gmail.com", "999999769", "123456");
        User u2 = new User(null, "oliviak", "oliviak@gmail.com", "999999943", "123456");
        User u3 = new User(null, "pinto", "pinto@gmail.com", "999999129", "123456");
        
        Order o1 = new Order(null, Instant.parse("2023-03-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2023-06-12T20:44:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2023-10-26T13:31:22Z"), u3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
