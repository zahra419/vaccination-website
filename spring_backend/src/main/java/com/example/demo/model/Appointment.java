package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    @Column(name = "appointment_date")
    private Date appointmentDate;
    @Column(name = "status")
    private String status;
    @Column(name = "doctor_cin")
    private String doctorCin;
    @Column(name = "center_id")
    private Integer centerId;
    @Column(name = "child_id")
    private Integer childId;
    @Column(name = "vaccin_id")
    private Integer vaccinId;

    public Appointment(){}

    public Appointment(Integer appointmentId, Date appointmentDate, String status,
                       String doctorCin, Integer centerId, Integer childId,Integer vaccinId) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.doctorCin = doctorCin;
        this.centerId = centerId;
        this.childId = childId;
        this.vaccinId=vaccinId;
    }

    // ===== GETTERS & SETTERS =====

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctorCin() {
        return doctorCin;
    }

    public void setDoctorCin(String doctorCin) {
        this.doctorCin = doctorCin;
    }

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(Integer centerId) {
        this.centerId = centerId;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }
    public void setVaccinId(Integer vaccinId){
        this.vaccinId=vaccinId;
    }
    public Integer getVaccinId(){return this.vaccinId;}
    
}
