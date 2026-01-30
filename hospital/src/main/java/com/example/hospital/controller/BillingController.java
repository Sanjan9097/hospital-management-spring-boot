package com.example.hospital.controller;


import com.example.hospital.dto.BillRequestDTO;
import com.example.hospital.entity.Bill;
import com.example.hospital.service.BillingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping
    public ResponseEntity<Bill> createBill(
            @Valid @RequestBody BillRequestDTO dto) {
        return new ResponseEntity<>(
                billingService.createBill(dto),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills(){
        return ResponseEntity.ok(billingService.getAllBills());
    }
    @GetMapping("/{billId}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long billId){
        return ResponseEntity.ok(billingService.getBillById(billId));
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getBillsByPatient(
            @PathVariable Long patientId
    ){
     return ResponseEntity.ok(billingService.getBillsByPatient(patientId));
    }

    @PutMapping("/{billId}/pay")
    public ResponseEntity<Bill> payBill(@PathVariable Long billId){
        Bill paidBill= billingService.payBill(billId);
        return ResponseEntity.ok(paidBill);
    }
}
