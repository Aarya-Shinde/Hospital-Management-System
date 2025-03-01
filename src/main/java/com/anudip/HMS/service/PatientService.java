package com.anudip.HMS.service;

import com.anudip.HMS.entity.Patient;
import com.anudip.HMS.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Fetch all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Fetch patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    // Add a new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update patient details
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        if (existingPatient != null) {
            existingPatient.setName(patientDetails.getName());
            existingPatient.setAge(patientDetails.getAge());
            existingPatient.setGender(patientDetails.getGender());
            existingPatient.setContact(patientDetails.getContact());
            existingPatient.setDisease(patientDetails.getDisease());
            existingPatient.setDoctor(patientDetails.getDoctor());
            return patientRepository.save(existingPatient);
        }
        return null;
    }

    // Delete patient
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}


//getAllPatients() → Returns a list of all patients.
//getPatientById(Long id) → Finds a patient by ID.
//addPatient(Patient patient) → Saves a new patient to the database.
//updatePatient(Long id, Patient patientDetails) → Modifies existing patient data.
//deletePatient(Long id) → Removes a patient from the database.