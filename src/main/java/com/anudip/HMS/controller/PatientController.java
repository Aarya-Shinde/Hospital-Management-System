package com.anudip.HMS.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.anudip.HMS.entity.Patient;
import com.anudip.HMS.service.PatientService;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:8080") // Allow frontend to access
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}



//@RestController → Marks this as a REST API controller.
//@RequestMapping("/patients") → Defines the base URL.
//@CrossOrigin(origins = "*") → Allows front-end apps to call APIs.
//@GetMapping → Retrieves patients.
//@PostMapping → Adds a new patient.
//@PutMapping → Updates patient details.
//@DeleteMapping → Deletes a patient.