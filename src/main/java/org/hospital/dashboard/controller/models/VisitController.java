package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Visit;
import org.hospital.dashboard.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

    @Autowired
    private VisitRepository visitR;

    //Get all visit data
    @GetMapping
    public List<Visit> getAllVisits() { return visitR.findAll(); }

    //Get visit by ID
    @GetMapping("/{visitID}")
    public Visit getVisitById(@PathVariable String visitID) { return visitR.findById(visitID).orElse(null); }

    //Create a new visit
    @PostMapping
    public Visit addVisit(@RequestBody Visit visit) { return visitR.save(visit); }

    //Update a visit
    @PatchMapping("/{visitID}")
    public Visit updateVisit(@PathVariable String visitID, @RequestBody Visit details) {
    Visit visit = visitR.findById(visitID).orElse(null);
        if (visit != null) {
            if(details.getPatient() != null) {
                visit.setPatient(details.getPatient());
            }
        if(details.getDoctor() !=null) {
            visit.setDoctor(details.getDoctor());
        }
        if(details.getDateOfVisit() !=null) {
            visit.setDateOfVisit(details.getDateOfVisit());
        }
        if(details.getSymptoms() !=null) {
            visit.setSymptoms(details.getSymptoms());
        }
        if(details.getDiagnosis() !=0) {
            visit.setDiagnosis(details.getDiagnosis());
        }
        return visitR.save(visit);
    }
    return null;
}
    //Replace existing visit data with new data
    @PutMapping("/{visitID}")
    public Visit replaceVisit(@PathVariable String visitID, @RequestBody Visit details) {
        Visit visit = visitR.findById(visitID).orElse(null);
        if (visit != null) {
            visit.setPatient(details.getPatient());
            visit.setDoctor(details.getDoctor());
            visit.setDateOfVisit(details.getDateOfVisit());
            visit.setSymptoms(details.getSymptoms());
            visit.setDiagnosis(details.getDiagnosis());
        }
        return null;
    }

    //Delete a visit
    @DeleteMapping("/{visitID}")
    public void deleteVisit(@PathVariable String visitID) { visitR.deleteById(visitID); }
}