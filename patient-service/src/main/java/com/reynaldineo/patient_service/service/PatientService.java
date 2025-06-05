package com.reynaldineo.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reynaldineo.patient_service.PatientMapper;
import com.reynaldineo.patient_service.dto.PatientResponseDTO;
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
}
