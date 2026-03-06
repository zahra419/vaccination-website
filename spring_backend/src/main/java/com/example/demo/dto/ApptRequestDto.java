package com.example.demo.dto;

import java.time.LocalDateTime;

public interface ApptRequestDto {
    Integer getAppointmentId();
    String getFullName();
    String getGender();
    String getVaccinName();
    LocalDateTime getAppointmentDate();
    String getStatus();
    String getCenterName();
    
} 
