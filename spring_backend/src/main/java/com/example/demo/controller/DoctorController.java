package com.example.demo.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AllAppointmentDto;
import com.example.demo.dto.ApptRequestDto;
import com.example.demo.dto.HistoryDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Vaccins;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.SearchService;
import com.example.demo.service.VaccinService;



@RestController
@RequestMapping("/api/doctor")
public class  DoctorController {

 
    private final SearchService searchService;
    private final VaccinService vaccinService;
    private final AppointmentService appointmentService;

    // Single constructor with both services
    public DoctorController( SearchService searchService,VaccinService vaccinService,AppointmentService appointmentService) {
        this.vaccinService=vaccinService;
        this.searchService = searchService;
        this.appointmentService=appointmentService;
    }


    // Page 2 – Vaccination history of one child
    @GetMapping("/search")
    public List<HistoryDto> getVaccinationHistory(@RequestParam("fullName") String fullName) {
        System.out.println("the name is "+fullName);
        return searchService.getVaccinationHistory(fullName);
    }

    @GetMapping("/vaccins")
    public List<Vaccins> getVaccins(){
        return vaccinService.getVaccins();
    }

    @PostMapping("/add")
    public Vaccins addVaccin(@RequestBody Vaccins newVaccin) {
        System.out.println(newVaccin);
        return vaccinService.addVaccin(newVaccin);
    }
    @GetMapping("/apprequest")
    public List<ApptRequestDto> getPendingAppointment(Authentication auth){
        String doctorCin=auth.getName();
        System.out.println(doctorCin);
        return appointmentService.getPendingAppointment(doctorCin);
    }
     @PutMapping("/accept/{id}/status")
    public ResponseEntity<Appointment> updateStatus(
        @PathVariable Long id,
        @RequestParam String status) {
      System.out.println("id value is"+id);
      System.out.println("status value is"+status);
    Appointment appointment = appointmentService.getAppointmentById(id);
    if (appointment == null) {
        return ResponseEntity.notFound().build();
    }

    appointment.setStatus(status);
    Appointment updated = appointmentService.updateAppointment(appointment);
    return ResponseEntity.ok(updated);
    }
    @GetMapping("/appointmentsTable")
    public List <AllAppointmentDto> getAllAppointments(Authentication auth){
        String doctorCin=auth.getName();
        System.out.println(doctorCin);
        return appointmentService.getAllAppointmentsByDoctorCin(doctorCin);
    }



    
}
