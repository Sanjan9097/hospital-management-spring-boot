package com.example.hospital.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    @Column(nullable = false)
    private double doctorCharges;

    @Column(nullable = false)
    private double medicineCharges;

    @Column(nullable = false)
    private double roomCharges;

    @Column(nullable = false)
    private double totalAmount;
    @Column(nullable = false)
    private String paymentStatus;
    @Column(nullable = false)
    private LocalDate billDate;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    public void setStatus(String paid) {
        System.out.println(paid);
    }

    public void setPaidDate(LocalDate now) {
        System.out.println(now);
    }
}
