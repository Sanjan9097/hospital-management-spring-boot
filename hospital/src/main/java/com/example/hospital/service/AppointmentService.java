package com.example.hospital.service;

import com.example.hospital.dto.AppointmentRequestDTO;
import com.example.hospital.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(AppointmentRequestDTO dto);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByPatient(Long patientId);
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    Appointment cancelAppointment(Long appointmentId);
}
