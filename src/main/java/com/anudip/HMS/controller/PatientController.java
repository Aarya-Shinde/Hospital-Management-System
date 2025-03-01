package com.anudip.HMS.controller;



import com.anudip.HMS.entity.Patient;
import com.anudip.HMS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*") // Allow cross-origin requests
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Get all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Get a single patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    // Add a new patient
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // Update patient details
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    // Delete patient
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}


//@RestController → Marks this as a REST API controller.
//@RequestMapping("/patients") → Defines the base URL.
//@CrossOrigin(origins = "*") → Allows front-end apps to call APIs.
//@GetMapping → Retrieves patients.
//@PostMapping → Adds a new patient.
//@PutMapping → Updates patient details.
//@DeleteMapping → Deletes a patient.