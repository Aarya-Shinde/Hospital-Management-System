package com.anudip.HMS.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments") // Ensures consistent table naming
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private LocalDate date;
    private LocalTime time;

    @Enumerated(EnumType.STRING) // Store enum as a string
    private Status status;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false) // Foreign key reference
    private Doctor doctor;

    // Enum for status
    public enum Status {
        SCHEDULED, CANCELED, COMPLETED
    }

    // Constructors
    public Appointment() {}

    public Appointment(String patientName, LocalDate date, LocalTime time, Status status, Doctor doctor) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.status = status;
        this.doctor = doctor;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
}
