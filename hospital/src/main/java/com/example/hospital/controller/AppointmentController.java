package com.example.hospital.controller;


import com.example.hospital.dto.AppointmentRequestDTO;
import com.example.hospital.entity.Appointment;
import com.example.hospital.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(
            @Valid @RequestBody AppointmentRequestDTO dto) {

        Appointment appointment = appointmentService.bookAppointment(dto);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(
            @PathVariable Long patientId
    ){
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientId));
    }

    @GetMapping("/doctor/{doctorId}")
    public  ResponseEntity<List<Appointment>> getAppointsByDoctor(
            @PathVariable Long doctorId
    ){
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctor(doctorId));
    }

    @PutMapping("/{appointmentId}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(
            @PathVariable Long appointmentId
    ){
        Appointment cancelled= appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.ok(cancelled);
    }

}
