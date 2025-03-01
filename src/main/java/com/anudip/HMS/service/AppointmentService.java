package com.anudip.HMS.service;

import com.anudip.HMS.entity.Appointment;
import com.anudip.HMS.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByDoctor(String doctorName, LocalDate date) {
        return appointmentRepository.findByDoctorNameAndDate(doctorName, date);
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void cancelAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
