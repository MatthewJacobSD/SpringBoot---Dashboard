package org.hospital.dashboard.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescription")

public class Prescription {

    @Id
    private String prescriptionID;

    @Column(nullable = false)
    private LocalDate datePrescribed;

    @Column(nullable = false)
    private int dosage;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drugID", referencedColumnName = "drugID")
    private Drug drug;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientID", referencedColumnName = "patientID")
    private Patient patient;

    public Prescription() {}

    public Prescription(String prescriptionID, LocalDate datePrescribed, int dosage, int duration, String comment, Drug drug, Doctor doctor, Patient patient){
        this.prescriptionID = prescriptionID;
        this.datePrescribed = datePrescribed;
        this.dosage = dosage;
        this.duration = duration;
        this.comment = comment;
        this.drug = drug;
        this.doctor = doctor;
        this.patient = patient;
    }

    //Getters
    public String getPrescriptionID() { return prescriptionID; }
    public LocalDate getDatePrescribed() { return datePrescribed; }
    public int getDosage() { return dosage; }
    public int getDuration() { return duration; }
    public String getComment() { return comment; }
    public Drug getDrug() { return drug; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    //Setters
    public void setPrescriptionID(String prescriptionID) { this.prescriptionID = prescriptionID; }
    public void setDatePrescribed(String datePrescribed) { this.datePrescribed = LocalDate.parse(datePrescribed); }
    public void setDosage(int dosage) { this.dosage = dosage; }
    public void setDuration(int duration) { this.duration = duration; }
    public void setComment(String comment) { this.comment = comment; }
    public void setDrug(Drug drug) { this.drug = drug; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public void setPatient(Patient patient) { this.patient = patient; }

}
