package com.example.hospital.repository;


import com.example.hospital.entity.Bill;
import com.example.hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
  List<Bill> findByPatient(Patient patient);
}
