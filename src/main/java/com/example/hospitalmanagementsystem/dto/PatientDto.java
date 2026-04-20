package com.example.hospitalmanagementsystem.dto;

/*
 * Patient DTO
 * Used to transfer patient data between layers
 */


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber;
}