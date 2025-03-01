package com.anudip.HMS.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;
    private String specialization;
    private String contact;
    private String email;
    private String availability;
    private String hospitalDepartment;
    private int experience;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    // Constructors, Getters, and Setters
}
