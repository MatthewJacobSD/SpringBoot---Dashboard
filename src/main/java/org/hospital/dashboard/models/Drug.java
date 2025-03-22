package org.hospital.dashboard.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drug")

public class Drug {

    @Id
    private String drugID;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String sideEffects;

    @Column(nullable = false)
    private String benefits;

    public Drug() {}

    public Drug(String drugID,  String name, String sideEffects, String benefits) {
        this.drugID = drugID;
        this.name = name;
        this.sideEffects = sideEffects;
        this.benefits = benefits;
    }

    //Getters
    public String getDrugID() { return drugID; }
    public String getName() { return name; }
    public String getSideEffects() { return sideEffects; }
    public String getBenefits() { return benefits; }

    public void setDrugID(String drugID) { this.drugID = drugID; }
    public void setName(String name) { this.name = name; }
    public void setSideEffects(String sideEffects) { this.sideEffects = sideEffects; }
    public void setBenefits(String benefits) { this.benefits = benefits; }


}
