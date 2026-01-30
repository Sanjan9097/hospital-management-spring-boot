package com.example.hospital.service;


import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()->
                new RuntimeException("Patient not found with id: "+id)
                );
    }

    @Override
    public Patient updatePatient(Long id) {
        return null;
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = getPatientById(id);

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setContact(patient.getContact());
        existingPatient.setDisease(patient.getDisease());

        return patientRepository.save(existingPatient);
    }


    @Override
    public void deletePatient(Long id) {
     patientRepository.delete(getPatientById(id));
    }
}
