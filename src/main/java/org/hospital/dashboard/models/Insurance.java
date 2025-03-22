package org.hospital.dashboard.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")

public class Insurance {

    @Id
    private String insuranceID;

    @Column(nullable=false, length=100)
    private String company;

    @Column(nullable=false, length=100)
    private String address;

    @Column(nullable=false, length=20)
    private String phoneNo;

    public Insurance() {}

    public Insurance(String insuranceID, String company, String address, String phoneNo) {
        this.insuranceID = insuranceID;
        this.company = company;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    //Getters
    public String getInsuranceID() { return insuranceID; }
    public String getCompany() { return company; }
    public String getAddress() { return address; }
    public String getPhoneNo() { return phoneNo; }

    //Setters
    public void setInsuranceID(String insuranceID) { this.insuranceID = insuranceID; }
    public void setCompany(String company) { this.company = company; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
}
