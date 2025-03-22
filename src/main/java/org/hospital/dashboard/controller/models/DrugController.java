package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Drug;
import org.hospital.dashboard.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {

    @Autowired
    private DrugRepository drugR;

    //Get all drug data
    @GetMapping
    public List<Drug> getAllDrugs() { return drugR.findAll(); }

    //Get drug by ID
    @GetMapping("/{drugID}")
    public Drug getDrugById(@PathVariable String drugID) { return drugR.findById(drugID).orElse(null); }

    //Create a new drug
    @PostMapping
    public Drug addDrug(@RequestBody Drug drug) { return drugR.save(drug); }

    //Update a drug
    @PatchMapping("/{drugID}")
    public Drug updateDrug(@PathVariable String drugID, @RequestBody Drug details) {
    Drug drug = drugR.findById(drugID).orElse(null);
        if (drug != null) {
            if(details.getName() != null) {
                drug.setName(details.getName());
            }
        if(details.getSideEffects() !=null) {
            drug.setSideEffects(details.getSideEffects());
        }
        if(details.getBenefits() !=null) {
            drug.setBenefits(details.getBenefits());
        }
        return drugR.save(drug);
    }
    return null;
}
    //Replace existing drug data with new data
    @PutMapping("/{drugID}")
    public Drug replaceDrug(@PathVariable String drugID, @RequestBody Drug details) {
        Drug drug = drugR.findById(drugID).orElse(null);
        if (drug != null) {
            drug.setName(details.getName());
            drug.setSideEffects(details.getSideEffects());
            drug.setBenefits(details.getBenefits());
        }
        return null;
    }

    //Delete a drug
    @DeleteMapping("/{drugID}")
    public void deleteDrug(@PathVariable String drugID) { drugR.deleteById(drugID); }
}