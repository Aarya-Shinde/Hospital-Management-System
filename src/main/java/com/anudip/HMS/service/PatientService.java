package com.anudip.HMS.service;

import com.anudip.HMS.entity.Patient;
import com.anudip.HMS.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient patientDetails) {
        return patientRepository.findById(id).map(existingPatient -> {
            existingPatient.setName(patientDetails.getName());
            existingPatient.setAge(patientDetails.getAge());
            existingPatient.setGender(patientDetails.getGender());
            existingPatient.setContact(patientDetails.getContact());
            existingPatient.setDisease(patientDetails.getDisease());
            existingPatient.setDoctor(patientDetails.getDoctor());
            return patientRepository.save(existingPatient);
        }).orElse(null);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
