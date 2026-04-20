package com.example.hospitalmanagementsystem.controller;
/*
 * Patient Controller
 * Handles CRUD APIs for patients
 */


import com.bridgelabz.hospitalmanagementsystem.dto.PatientDto;
import com.bridgelabz.hospitalmanagementsystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    // CREATE
    @PostMapping
    public PatientDto createPatient(@RequestBody PatientDto dto) {
        return patientService.createPatient(dto);
    }

    // READ ALL
    @GetMapping
    public List<PatientDto> getAllPatients() {
        return patientService.getAllPatients();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable Long id, @RequestBody PatientDto dto) {
        return patientService.updatePatient(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }
}