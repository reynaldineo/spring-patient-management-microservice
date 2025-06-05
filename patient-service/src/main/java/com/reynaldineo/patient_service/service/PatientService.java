package com.reynaldineo.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reynaldineo.patient_service.PatientMapper;
import com.reynaldineo.patient_service.dto.PatientRequestDTO;
import com.reynaldineo.patient_service.dto.PatientResponseDTO;
import com.reynaldineo.patient_service.exception.EmailAlreadyExistException;
import com.reynaldineo.patient_service.model.Patient;
import com.reynaldineo.patient_service.repository.PatientRepository;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> PatientMapper.toDTO(patient))
                .toList();
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistException(
                    "A patient with this email " + "already exists " + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
