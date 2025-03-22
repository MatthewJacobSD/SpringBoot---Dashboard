package org.hospital.dashboard.controller.models;

import org.hospital.dashboard.models.Doctor;
import org.hospital.dashboard.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorR;

    //Get all doctor data
    @GetMapping
    public List<Doctor> getAllDoctors() { return doctorR.findAll(); }

    //Get doctor by ID
    @GetMapping("/{doctorID}")
    public Doctor getDoctorById(@PathVariable String doctorID) { return doctorR.findById(doctorID).orElse(null); }

    //Create a new doctor
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) { return doctorR.save(doctor); }

    //Update a doctor
    @PatchMapping("/{doctorID}")
    public Doctor updateDoctor(@PathVariable String doctorID, @RequestBody Doctor details) {
    Doctor doctor = doctorR.findById(doctorID).orElse(null);
        if (doctor != null) {
            if(details.getFirstname() != null) {
                doctor.setFirstname(details.getFirstname());
            }
        if(details.getSurname() !=null) {
            doctor.setSurname(details.getSurname());
        }
        if(details.getAddress() !=null) {
            doctor.setAddress(details.getAddress());
        }
        if(details.getEmail() !=null) {
            doctor.setEmail(details.getEmail());
        }
        if(details.getSpecialisation() !=null) {
            doctor.setSpecialisation(details.getSpecialisation());
        }
        return doctorR.save(doctor);
    }
    return null;
}
    //Replace existing doctor data with new data
    @PutMapping("/{doctorID}")
    public Doctor replaceDoctor(@PathVariable String doctorID, @RequestBody Doctor details) {
        Doctor doctor = doctorR.findById(doctorID).orElse(null);
        if (doctor != null) {
            doctor.setFirstname(details.getFirstname());
            doctor.setSurname(details.getSurname());
            doctor.setAddress(details.getAddress());
            doctor.setEmail(details.getEmail());
            doctor.setSpecialisation(details.getSpecialisation());
        }
        return null;
    }

    //Delete a doctor
    @DeleteMapping("/{doctorID}")
    public void deleteDoctor(@PathVariable String doctorID) { doctorR.deleteById(doctorID); }
}