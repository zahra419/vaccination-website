package com.example.demo.dto;

import java.sql.Date;

public class HistoryDto {
    private String vaccinName;
    private String centerName;
    private String doctorFullName;
    private Date vaccinationDate;
    private String childFullName;

    public HistoryDto(String vaccinName,String centerName,String doctorFullName,Date vaccinationDate,String childFullName){
        this.vaccinName=vaccinName;
        this.centerName=centerName;
        this.doctorFullName=doctorFullName;
        this.vaccinationDate=vaccinationDate;
        this.childFullName=childFullName;
    }
 
    // Getters and Setters
    public HistoryDto(){

    }
    public String getChildFullName(){
        return this.childFullName;
    }
    public void setChildFullName(String childFullName){
        this.childFullName=childFullName;
    }
    public String getVaccinName() {
        return vaccinName;
    }

    public void setVaccinName(String vaccinName) {
        this.vaccinName = vaccinName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public Date getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(Date vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }
}

