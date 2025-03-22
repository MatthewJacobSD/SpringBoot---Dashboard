package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Patient;
import org.hospital.dashboard.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientR;

    //Get all patient data
    @GetMapping
    public List<Patient> getAllPatients() { return patientR.findAll(); }

    //Get patient by ID
    @GetMapping("/{patientID}")
    public Patient getPatientById(@PathVariable String patientID) { return patientR.findById(patientID).orElse(null); }

    //Create a new patient
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) { return patientR.save(patient); }

    //Update a patient
    @PatchMapping("/{patientID}")
    public Patient updatePatient(@PathVariable String patientID, @RequestBody Patient details) {
    Patient patient = patientR.findById(patientID).orElse(null);
        if (patient != null) {
            if(details.getFirstname() != null) {
                patient.setFirstname(details.getFirstname());
            }
        if(details.getSurname() !=null) {
            patient.setSurname(details.getSurname());
        }
        if(details.getPostcode() != null) {
            patient.setPostcode(details.getPostcode());
        }
        if(details.getAddress() !=null) {
            patient.setAddress(details.getAddress());
        }
        if(details.getPhoneNo() != null) {
            patient.setPhoneNo(details.getPhoneNo());
        }
        if(details.getEmail() !=null) {
            patient.setEmail(details.getEmail());
        }
        if(details.getInsurance() !=null) {
            patient.setInsurance(details.getInsurance());
        }
        return patientR.save(patient);
    }
    return null;
}
    //Replace existing patient data with new data
    @PutMapping("/{patientID}")
    public Patient replacePatient(@PathVariable String patientID, @RequestBody Patient details) {
        Patient patient = patientR.findById(patientID).orElse(null);
        if (patient != null) {
            patient.setFirstname(details.getFirstname());
            patient.setSurname(details.getSurname());
            patient.setPostcode(details.getPostcode());
            patient.setAddress(details.getAddress());
            patient.setPhoneNo(details.getPhoneNo());
            patient.setEmail(details.getEmail());
            patient.setInsurance(details.getInsurance());
        }
        return null;
    }

    //Delete a patient
    @DeleteMapping("/{patientID}")
    public void deletePatient(@PathVariable String patientID) { patientR.deleteById(patientID); }
}