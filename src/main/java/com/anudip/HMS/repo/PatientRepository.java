package com.anudip.HMS.repo;


import com.anudip.HMS.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByContact(String contact); // Find patient by contact
}


//Extends JpaRepository<Patient, Long> → Provides CRUD methods automatically.
//findByContact(String contact) → Custom method to fetch a patient by contact number.