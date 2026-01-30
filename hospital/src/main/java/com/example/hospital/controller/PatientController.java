package com.example.hospital.controller;


import com.example.hospital.entity.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import  java.util.List;
@RestController
@RequestMapping("/api/patients")
public class PatientController {
   @Autowired
    private PatientService patientService;

   @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
       Patient savedPatient= patientService.addPatient(patient);
       return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
   }
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients(){
       return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id){
       return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,@RequestBody Patient patient){
       Patient updatePatient = patientService.updatePatient(id,patient);
       return ResponseEntity.ok(updatePatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
       patientService.deletePatient(id);
       return ResponseEntity.ok("Patient details deleted successfully");
    }

}
