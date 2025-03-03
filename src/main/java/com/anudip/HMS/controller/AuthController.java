package com.anudip.HMS.controller;

import com.anudip.HMS.entity.User;
import com.anudip.HMS.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;


import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/")
    public ResponseEntity<String> homePage() {
        return ResponseEntity.ok("Welcome to Smart Hospital Home Page!");
    }

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest, HttpSession session) {
        Optional<User> user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (user.isPresent()) {
            session.setAttribute("user", user.get());

            // ✅ Return JSON response instead of plain text
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful!");
            response.put("role", user.get().getRole().toString());

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid credentials"));
    }


    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (user.getRole() == null) {
            return ResponseEntity.badRequest().body("Role is required (PATIENT, DOCTOR, ADMIN)");
        }
        return ResponseEntity.ok(userService.register(user));
    }
}
