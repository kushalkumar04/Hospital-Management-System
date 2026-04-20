package com.example.hospitalmanagementsystem.dto;

/*
 * AuthResponse DTO
 * Used for sending login response with JWT
 */

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String token;
    private String message;
}