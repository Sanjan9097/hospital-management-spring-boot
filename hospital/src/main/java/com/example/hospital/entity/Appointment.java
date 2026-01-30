package com.example.hospital.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
@Column(nullable = false)
    private LocalDate appointmentDate;
@Column(nullable = false)
    private LocalTime appointmentTime;
@Column(nullable = false)
    private String status;
@ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

@ManyToOne
@JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;
}
