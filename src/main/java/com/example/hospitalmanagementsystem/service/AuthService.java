package com.example.hospitalmanagementsystem.service;

/*
 * Auth Service
 * Handles user registration and login logic
 */

import com.bridgelabz.hospitalmanagementsystem.dto.AuthRequest;
import com.bridgelabz.hospitalmanagementsystem.dto.AuthResponse;
import com.bridgelabz.hospitalmanagementsystem.entity.Role;
import com.bridgelabz.hospitalmanagementsystem.entity.User;
import com.bridgelabz.hospitalmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // REGISTER
    public String registerUser(AuthRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return "User already exists";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);

        userRepository.save(user);

        return "User registered successfully";
    }

    // LOGIN (JWT will come later)
    public AuthResponse loginUser(AuthRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponse(null, "Login successful"); // token later
    }
}