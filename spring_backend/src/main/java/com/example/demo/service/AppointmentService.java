package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApptRequestDto;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.ApptRequestRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ApptRequestRepository apptRequestRepository;
    public AppointmentService(AppointmentRepository appointmentRepository,ApptRequestRepository apptRequestRepository){
        this.appointmentRepository=appointmentRepository;
        this.apptRequestRepository=apptRequestRepository;
    }

    public Appointment addAppointment(Appointment newAppointment){
        return appointmentRepository.save(newAppointment);
    }
    public List<ApptRequestDto> getPendingAppointment(String doctorCin){
        return apptRequestRepository.findPendingAppointment(doctorCin);
    }
    
}
