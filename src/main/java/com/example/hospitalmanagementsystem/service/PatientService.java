package com.example.hospitalmanagementsystem.service;

/*
 * Patient Service
 * Handles business logic for patient operations
 */


import com.bridgelabz.hospitalmanagementsystem.dto.PatientDto;
import com.bridgelabz.hospitalmanagementsystem.entity.Patient;
import com.bridgelabz.hospitalmanagementsystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    // CREATE
    public PatientDto createPatient(PatientDto dto) {

        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDisease(dto.getDisease());
        patient.setAddress(dto.getAddress());
        patient.setPhoneNumber(dto.getPhoneNumber());

        Patient saved = patientRepository.save(patient);

        dto.setId(saved.getId());
        return dto;
    }

    // READ ALL
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // READ BY ID
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return convertToDto(patient);
    }

    // UPDATE
    public PatientDto updatePatient(Long id, PatientDto dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setDisease(dto.getDisease());
        patient.setAddress(dto.getAddress());
        patient.setPhoneNumber(dto.getPhoneNumber());

        patientRepository.save(patient);

        return convertToDto(patient);
    }

    // DELETE
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // CONVERTER
    private PatientDto convertToDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getAge(),
                patient.getGender(),
                patient.getDisease(),
                patient.getAddress(),
                patient.getPhoneNumber()
        );
    }
}