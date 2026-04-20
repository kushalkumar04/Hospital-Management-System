package com.example.hospitalmanagementsystem.controller;

/*
 * Auth Controller
 * Handles authentication APIs (register, login)
 */


import com.example.hospitalmanagementsystem.dto.AuthRequest;
import com.example.hospitalmanagementsystem.dto.AuthResponse;
import com.example.hospitalmanagementsystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        return authService.registerUser(request);
    }

    // LOGIN
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.loginUser(request);
    }
}