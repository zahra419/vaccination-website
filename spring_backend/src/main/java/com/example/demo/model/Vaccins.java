package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vaccins")
public class Vaccins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccin_id")
    private Long vaccinId;

    @Column(name = "vaccin_name",nullable = false)

    private String vaccinName;
    
    @Column(name = "fabricant",nullable = false)
    private String fabricant;

    @Column(name = "month_due")
    private Integer monthDue;

    // Constructor with fields (without ID)
    public Vaccins(String vaccinName, String fabricant, Integer monthDue) {
        this.vaccinName = vaccinName;
        this.fabricant = fabricant;
        this.monthDue = monthDue;
    }

    // Default constructor (required by JPA)
    public Vaccins() {
    }

    // Getters and Setters

    public Long getVaccinId() {
        return vaccinId;
    }

    public void setVaccinId(Long vaccinId) {
        this.vaccinId = vaccinId;
    }

    public String getVaccinName() {
        return this.vaccinName;
    }

    public void setVaccinName(String vaccinName) {
        this.vaccinName = vaccinName;
    }

    public String getFabricant() {
        return this.fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public Integer getMonthDue() {
        return this.monthDue;
    }

    public void setMonthDue(Integer monthDue) {
        this.monthDue = monthDue;
    }
}

