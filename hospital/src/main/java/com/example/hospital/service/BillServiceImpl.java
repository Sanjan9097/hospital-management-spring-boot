package com.example.hospital.service;

import com.example.hospital.dto.BillRequestDTO;
import com.example.hospital.entity.Bill;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.BillRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BillServiceImpl implements BillingService{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;



    @Override
    public Bill createBill(BillRequestDTO dto) {

        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Bill bill = new Bill();
        bill.setDoctorCharges(dto.getDoctorCharges());
        bill.setMedicineCharges(dto.getMedicineCharges());
        bill.setRoomCharges(dto.getRoomCharges());
        bill.setTotalAmount(dto.getTotalAmount());
        bill.setPaymentStatus(
                dto.getPaymentStatus() != null ? dto.getPaymentStatus() : "UNPAID"
        );
        bill.setBillDate(LocalDate.now());
        bill.setPatient(patient);

        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElseThrow(()->
                new RuntimeException("Bill not found with id: "+ billId)
                );
    }

    @Override
    public List<Bill> getBillsByPatient(Long patientId) {
        Patient patient= patientRepository.findById(patientId).orElseThrow(()->
                new RuntimeException("Patient not found")
                );
        return billRepository.findByPatient(patient);
    }

    @Override
    public Bill payBill(Long billId) {
        Bill bill=billRepository.findById(billId).orElseThrow(()->
                new RuntimeException("Bill not found with id: "+ billId));
             bill.setStatus("PAID");
             bill.setPaidDate(LocalDate.now());

        return billRepository.save(bill);
    }
}
