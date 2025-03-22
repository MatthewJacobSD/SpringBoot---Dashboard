package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Insurance;
import org.hospital.dashboard.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {

    @Autowired
    private InsuranceRepository insuranceR;

    //Get all insurance data
    @GetMapping
    public List<Insurance> getAllInsurances() { return insuranceR.findAll(); }

    //Get insurance by ID
    @GetMapping("/{insuranceID}")
    public Insurance getInsuranceById(@PathVariable String insuranceID) { return insuranceR.findById(insuranceID).orElse(null); }

    //Create a new insurance
    @PostMapping
    public Insurance addInsurance(@RequestBody Insurance insurance) { return insuranceR.save(insurance); }

    //Update an insurance
    @PatchMapping("/{insuranceID}")
    public Insurance updateInsurance(@PathVariable String insuranceID, @RequestBody Insurance details) {
    Insurance insurance = insuranceR.findById(insuranceID).orElse(null);
        if (insurance != null) {
            if(details.getCompany() != null) {
                insurance.setCompany(details.getCompany());
            }
        if(details.getAddress() !=null) {
            insurance.setAddress(details.getAddress());
        }
        if(details.getPhoneNo() !=null) {
            insurance.setPhoneNo(details.getPhoneNo());
        }
        return insuranceR.save(insurance);
    }
    return null;
}
    //Replace existing insurance data with new data
    @PutMapping("/{insuranceID}")
    public Insurance replaceInsurance(@PathVariable String insuranceID, @RequestBody Insurance details) {
        Insurance insurance = insuranceR.findById(insuranceID).orElse(null);
        if (insurance != null) {
            insurance.setCompany(details.getCompany());
            insurance.setAddress(details.getAddress());
            insurance.setPhoneNo(details.getPhoneNo());
        }
        return null;
    }

    //Delete an insurance
    @DeleteMapping("/{insuranceID}")
    public void deleteInsurance(@PathVariable String insuranceID) { insuranceR.deleteById(insuranceID); }
}