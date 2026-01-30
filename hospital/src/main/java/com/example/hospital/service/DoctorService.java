package com.example.hospital.service;

import com.example.hospital.entity.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    Doctor updateDoctor(Long id,Doctor doctor);

    void deleteDoctor(Long id);

}
