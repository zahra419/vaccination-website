package com.example.demo.dto;

import java.time.LocalDateTime;

public interface ApptRequestDto {
    Integer getAppointmentId();
    String getFullName();
    String getGender();
    String getVaccinName();
    LocalDateTime getAppointmentDate();
    String getStatus();

    
} 
/*ApptRequestDto {
    

    public ApptRequestDto(Integer appointmentId,String fullName,String gender,String vaccinName,Date appoinDate){
        this.appointmentId=appointmentId;
        this.fullName=fullName;
        this.gender=gender;
        this.vaccinName=vaccinName;
        this.appointmentDate=appointmentDate;
    }
   
    public void setFullName(String fullName){this.fullName=fullName;}
    public String getFullName(){return this.fullName;}
    public Integer getAppointmentId(){return this.appointmentId;}
    public String getGender(){return this.gender;}
    public void setGender(String gender){this.gender=gender;}
    public Date getAppointmentDate(){return this.appointmentDate;}
    public void setAppointmentDate(Date appointmenDate){this.appointmentDate=appointmenDate;}
    public String getVaccinName(){return this.vaccinName;}
    public void setVaccinName(String vaccinName){this.vaccinName=vaccinName;}
    
    
}*/
