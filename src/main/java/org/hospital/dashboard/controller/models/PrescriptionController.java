package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Prescription;
import org.hospital.dashboard.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionR;

    //Get all prescription data
    @GetMapping
    public List<Prescription> getAllPrescriptions() { return prescriptionR.findAll(); }

    //Get prescription by ID
    @GetMapping("/{prescriptionID}")
    public Prescription getPrescriptionById(@PathVariable String prescriptionID) { return prescriptionR.findById(prescriptionID).orElse(null); }

    //Create a new prescription
    @PostMapping
    public Prescription addPrescription(@RequestBody Prescription prescription) { return prescriptionR.save(prescription); }

    //Update a prescription
    @PatchMapping("/{prescriptionID}")
    public Prescription updatePrescription(@PathVariable String prescriptionID, @RequestBody Prescription details) {
    Prescription prescription = prescriptionR.findById(prescriptionID).orElse(null);
        if (prescription != null) {
            if(details.getDatePrescribed() != null) {
                prescription.setDatePrescribed(String.valueOf(details.getDatePrescribed()));
            }
        if(details.getDosage() !=0) {
            prescription.setDosage(details.getDosage());
        }
            if(details.getDuration() !=0) {
                prescription.setDuration(details.getDuration());
            }
            if(details.getComment() != null) {
            prescription.setComment(details.getComment());
        }
            if(details.getDrug() !=null) {
            prescription.setDrug(details.getDrug());
        }
            if(details.getDoctor() != null) {
            prescription.setDoctor(details.getDoctor());
        }
            if(details.getPatient() !=null) {
            prescription.setPatient(details.getPatient());
        }
        return prescriptionR.save(prescription);
    }
    return null;
}
    //Replace existing prescription data with new data
    @PutMapping("/{prescriptionID}")
    public Prescription replacePrescription(@PathVariable String prescriptionID, @RequestBody Prescription details) {
        Prescription prescription = prescriptionR.findById(prescriptionID).orElse(null);
        if (prescription != null) {
            prescription.setDatePrescribed(String.valueOf(details.getDatePrescribed()));
            prescription.setDosage(details.getDosage());
            prescription.setDuration(details.getDuration());
            prescription.setComment(details.getComment());
            prescription.setDrug(details.getDrug());
            prescription.setDoctor(details.getDoctor());
            prescription.setPatient(details.getPatient());
        }
        return null;
    }

    //Delete a prescription
    @DeleteMapping("/{prescriptionID}")
    public void deletePrescription(@PathVariable String prescriptionID) { prescriptionR.deleteById(prescriptionID); }
}