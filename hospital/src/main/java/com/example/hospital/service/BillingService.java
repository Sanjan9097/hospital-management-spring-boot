package com.example.hospital.service;

import com.example.hospital.dto.BillRequestDTO;
import com.example.hospital.entity.Bill;

import java.util.List;

public interface BillingService {
    Bill createBill(BillRequestDTO dto);
   List<Bill> getAllBills();
   Bill getBillById(Long billId);
   List<Bill> getBillsByPatient(Long patientId);

    Bill payBill(Long billId);
}
