package com.example.hospitalmanagementsystem.repository;

/*
 * Patient Repository
 * Handles DB operations for Patient
 */

import com.bridgelabz.hospitalmanagementsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}