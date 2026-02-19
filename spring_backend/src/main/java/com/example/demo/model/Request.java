package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Request {
    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "doctor_cin")  // FK column in the database
    private Users user;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Centers center;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    private Vaccins vaccin;

    public Request(Integer appointmentId, String appointmentDate, String status,
                       Users user, Centers center, Child child,Vaccins vaccin) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.user = user;
        this.center = center;
        this.child= child;
        this.vaccin=vaccin;
    }
  
    // ===== GETTERS & SETTERS =====

   public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Centers getCenter() {
        return center;
    }

    public void setCenter(Centers center) {
        this.center = center;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Vaccins getVaccin() {
        return vaccin;
    }

    public void setVaccin(Vaccins vaccin) {
        this.vaccin = vaccin;
    }
    
}
