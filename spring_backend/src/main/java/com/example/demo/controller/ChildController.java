package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.example.demo.dto.ChildDto;
import com.example.demo.dto.DoctorDto;
import com.example.demo.dto.HistoryDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Centers;
import com.example.demo.model.Vaccins;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.CenterService;
import com.example.demo.service.ChildService;
import com.example.demo.service.DoctorsService;
import com.example.demo.service.HistoryService;
import com.example.demo.service.PercentageService;
import com.example.demo.service.UpcomingService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/patient")
public class ChildController {

    private final ChildService service;
    private final HistoryService historyService;
    private final PercentageService percentageService;
    private final UpcomingService upcomingService;
    private final CenterService centerService;
    private final DoctorsService doctorsService;
    private final AppointmentService appointmentService;

    // Single constructor with both services
    public ChildController(ChildService service,AppointmentService appointmentService, HistoryService historyService, PercentageService percentageService,UpcomingService upcomingService,CenterService centerService, DoctorsService doctorsService) {
        this.service = service;
        this.historyService = historyService;
        this.percentageService=percentageService;
        this.upcomingService=upcomingService;
        this.centerService=centerService;
        this.doctorsService=doctorsService;
        this.appointmentService=appointmentService;
    }

    // Page 1 – Children list
    @GetMapping
    public List<ChildDto> getChildrenOfUser(Authentication auth) {
        String userCin = auth.getName();
        return service.getChildrenOfUser(userCin);
    }

    // Page 2 – Vaccination history of one child
    @GetMapping("/{id}")
    public List<HistoryDto> getVaccinationHistory(@PathVariable("id") long id) {
        return historyService.getVaccinationHistory(id);
    }

    @GetMapping("/progress/{id}")
    public double getVaccinationPercentage(@PathVariable("id") Long id) {
        System.out.println("the value is"+id);
        return percentageService.getVaccinationPercentage(id);
    }
    @GetMapping("/upcoming/{id}")
    public Optional<Vaccins> getUpcomingVaccin(@PathVariable("id") Long id){
        return upcomingService.getUpcomingVaccin(id);
    }
    @GetMapping("/centers")
    public List<Centers> getCenters() {
        return centerService.getCenters();
    }
    @GetMapping("/centers/{selectedCenter}")
    public List<DoctorDto> getDoctorsOfCenter(@PathVariable long selectedCenter) {
        System.out.println(selectedCenter);
        return doctorsService.getDoctorsOfCenter(selectedCenter);
    }
    @PostMapping("/appt")
    public Appointment addAppointment(@RequestBody Appointment newAppointment){
        System.out.println(newAppointment);
        return appointmentService.addAppointment(newAppointment);
        //change doctordto
    }
    
}
