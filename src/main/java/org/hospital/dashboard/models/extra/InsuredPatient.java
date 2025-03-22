package org.hospital.dashboard.models.extra;

import org.hospital.dashboard.models.Insurance;
import org.hospital.dashboard.models.Patient;

public class InsuredPatient extends Patient {

    private String type;
    private String companyName;
    private String duration;

    public InsuredPatient(String patientID, String firstname, String surname, String postcode, String address, String phoneNo, String email, Insurance insuranceID) {
        super(patientID, firstname, surname, postcode, address, phoneNo, email, insuranceID);
        this.type = "";
        this.companyName = "";
        this.duration = "";
    }

    //Getters
    public String getType() { return type; }
    public String getCompanyName() { return companyName; }
    public String getDuration() { return duration; }

    //Setters
    public void setType(String type) { this.type = "insured"; }
    public void setCompanyName(String companyName) { this.companyName = "NHS"; }
    public void setDuration(String duration) { this.duration = "not listed"; }
}
