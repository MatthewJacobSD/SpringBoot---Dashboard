package org.hospital.dashboard.models.extra;

import org.hospital.dashboard.models.Doctor;

public class Specialist extends Doctor {

    private String education;

    public Specialist(String doctorID, String firstname, String surname, String address, String email, String specialisation) {
        super(doctorID, firstname, surname, address, email, specialisation);
        this.education = "";
    }

    //Getter & Setter
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = "Medical Education"; }
}
