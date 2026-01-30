package com.example.hospital.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillRequestDTO {
    @NotNull
    private double doctorCharges;

    @NotNull
    private double medicineCharges;

    @NotNull
    private double roomCharges;

    @NotNull
    private double totalAmount;

    private String paymentStatus;

    @NotNull
    private Long patientId;
}
