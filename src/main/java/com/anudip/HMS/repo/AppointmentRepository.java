package com.anudip.HMS.repo;

import com.anudip.HMS.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctor_NameAndDate(String name, LocalDate date); // Find appointments by doctor name and date
}
