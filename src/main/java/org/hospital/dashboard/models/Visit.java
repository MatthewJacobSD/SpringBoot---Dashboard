package org.hospital.dashboard.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "visit")

public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String visitID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientID", referencedColumnName = "patientID")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    private Doctor doctor;

    @Column(name = "dateOfVisit")
    private LocalDate dateOfVisit;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "diagnosis")
    private int diagnosis;

    public Visit() {}

    public Visit(String visitID, Patient patient, Doctor doctor, LocalDate dateOfVisit, String symptoms, int diagnosis) {
        this.visitID = visitID;
        this.patient = patient;
        this.doctor = doctor;
        this.dateOfVisit = dateOfVisit;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
    }

    //Getters
    public String getVisitID() { return visitID; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDate getDateOfVisit() { return dateOfVisit; }
    public String getSymptoms() { return symptoms; }
    public int getDiagnosis() { return diagnosis; }

    //Setters
    public void setVisitID(String visitID) { this.visitID = visitID; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setDateOfVisit(LocalDate dateOfVisit) { this.dateOfVisit = dateOfVisit; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public void setDiagnosis(int diagnosis) { this.diagnosis = diagnosis; }
}
