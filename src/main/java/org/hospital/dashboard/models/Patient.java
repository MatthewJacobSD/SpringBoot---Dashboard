package org.hospital.dashboard.models;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")

public class Patient {

    @Id
    private String patientID;

    @Column(nullable = false, length = 10)
    private String firstname;

    @Column(nullable = false, length = 20)
    private String surname;

    @Column(nullable = false, length = 10)
    private String postcode;

    @Column(nullable=false, length = 100)
    private String address;

    @Column(nullable = false, length = 10)
    private String phoneNo;

    @Column(nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insuranceID", referencedColumnName = "insuranceID")
    private Insurance insurance;

    public Patient() {}

    public Patient(String patientID, String firstname, String surname, String postcode, String address, String phoneNo, String email, Insurance insurance) {
        this.patientID = patientID;
        this.firstname = firstname;
        this.surname = surname;
        this.postcode = postcode;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
        this.insurance = insurance;
    }

    public String getPatientID() { return patientID; }
    public String getFirstname() { return firstname; }
    public String getSurname() { return surname; }
    public String getPostcode() { return postcode; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }
    public String getEmail() { return email; }
    public Insurance getInsurance() { return insurance; }

    public void setPatientID(String patientID) { this.patientID = patientID; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
    public void setEmail(String email) { this.email = email; }
    public void setInsurance(Insurance insurance) { this.insurance = insurance; }
}
