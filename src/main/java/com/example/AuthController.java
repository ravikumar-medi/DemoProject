package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("request", new UserRegistrationRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserRegistrationRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        try {
            userService.registerUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            result.rejectValue("email", "", "User already exists with this email");
            return "register";
        }
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}