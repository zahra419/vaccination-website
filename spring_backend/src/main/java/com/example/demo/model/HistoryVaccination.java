package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "historique_vaccination")
public class HistoryVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="historique_id")
    private Long historiqueId;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccins vaccins;
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Centers center;
    @ManyToOne
    @JoinColumn(name = "doctor_cin")
    private Users doctorCin;
    @Column(name="vaccination_date")
    private Date vaccinationDate;

    public HistoryVaccination(long historiqueId, Child child,Vaccins vaccins,Centers center,Users doctorCin,Date vaccinationDate){
      this.historiqueId=historiqueId;
      this.child=child;
      this.vaccins=vaccins;
      this.center=center;
      this.doctorCin=doctorCin;
      this.vaccinationDate=vaccinationDate;
    }
     public HistoryVaccination() {
    }

    // Getters and Setters

    public Long getHistoriqueId() {
        return this.historiqueId;
    }

    public void setHistoriqueId(Long historiqueId) {
        this.historiqueId = historiqueId;
    }

    public Child getChild() {
        return this.child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Vaccins getVaccins() {
        return this.vaccins;
    }

    public void setVaccins(Vaccins vaccins) {
        this.vaccins = vaccins;
    }

    public Centers getCenter() {
        return this.center;
    }

    public void setCenter(Centers center) {
        this.center = center;
    }

    public Users getDoctorCin() {
        return this.doctorCin;
    }

    public void setDoctorCin(Users doctorCin) {
        this.doctorCin = doctorCin;
    }

    public Date getVaccinationDate() {
        return this.vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}
