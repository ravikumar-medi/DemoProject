package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Check if user already exists
        if (userService.findByEmail("ravikumar.medi@empover.com").isEmpty()) {
            UserRegistrationRequest request = new UserRegistrationRequest();
            request.setEmail("ravikumar.medi@empover.com");
            request.setPassword("Ravi@J");
            request.setFirstName("Ravikumar");
            request.setLastName("Medi");
            request.setPhone("9876543210");
            request.setCity("Hyderabad");
            request.setCountry("India");
            userService.registerUser(request);
        }
    }
}