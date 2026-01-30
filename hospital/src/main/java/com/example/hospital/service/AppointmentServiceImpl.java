package com.example.hospital.service;

import com.example.hospital.dto.AppointmentRequestDTO;
import com.example.hospital.entity.Appointment;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class AppointmentServiceImpl implements  AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Appointment bookAppointment(AppointmentRequestDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setStatus(
                dto.getStatus() != null ? dto.getStatus() : "BOOKED"
        );

        return appointmentRepository.save(appointment);
    }




    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        Patient patient= patientRepository.findById(patientId).orElseThrow(()->
                new RuntimeException("Patient not found")
                );
        return appointmentRepository.findByPatient(patient);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        Doctor doctor= doctorRepository.findById(doctorId).orElseThrow(()->
                new RuntimeException(("Doctor not found"))
                );
        return appointmentRepository.findByDoctor(doctor);
    }

    @Override
    public Appointment cancelAppointment(Long appointmentId) {
        Appointment appointment= appointmentRepository.findById(appointmentId).orElseThrow(()->
                new RuntimeException("Appointment not found")
                );
        appointment.setStatus("Cancelled");
        return appointmentRepository.save(appointment);
    }
}
