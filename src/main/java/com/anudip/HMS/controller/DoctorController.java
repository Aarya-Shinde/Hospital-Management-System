package com.anudip.HMS.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.anudip.HMS.entity.Doctor;
import com.anudip.HMS.service.DoctorService;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:5500")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}
