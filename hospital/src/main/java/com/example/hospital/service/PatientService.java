package com.example.hospital.service;

import com.example.hospital.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Long id);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}

