package org.hospital.dashboard.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "doctor")

public class Doctor {

    @Id
    private String doctorID;

    @Column(nullable = false, length = 20)
    private String firstname;

    @Column(nullable = false, length = 20)
    private String surname;

    @Column(nullable = false, length = 20)
    private String address;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 30)
    private String specialisation;

    //Constructors
    public Doctor() {}

    public Doctor(String doctorID, String firstname, String surname, String address, String email, String specialisation) {
        this.doctorID = doctorID;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.specialisation = specialisation;
    }

    //Getters
    public String getDoctorID() { return doctorID; }
    public String getFirstname() { return firstname; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getSpecialisation() { return specialisation; }

    //Setters
    public void setDoctorID(String doctorID) { this.doctorID = doctorID; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setSpecialisation(String specialisation) { this.specialisation = specialisation; }

}
