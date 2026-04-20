package com.example.hospitalmanagementsystem.entity;

/*
 * Patient Entity
 * Represents patient table in database
 */


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String disease;
    private String address;
    private String phoneNumber;
}