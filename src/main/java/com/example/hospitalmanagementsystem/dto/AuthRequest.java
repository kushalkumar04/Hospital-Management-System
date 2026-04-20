package com.example.hospitalmanagementsystem.dto;

/*
 * AuthRequest DTO
 * Used for login and registration input
 */


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {

    private String name;     // used in register
    private String email;
    private String password;
}