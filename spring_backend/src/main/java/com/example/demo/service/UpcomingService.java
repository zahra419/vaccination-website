package com.example.demo.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Appointment;
import com.example.demo.model.Vaccins;
import com.example.demo.repository.UpcomingRepository;

@Service
public class UpcomingService {
    @Autowired
    private UpcomingRepository upcomingRepository;
    public UpcomingService(UpcomingRepository upcomingRepository){
        this.upcomingRepository=upcomingRepository;
    }
    public Optional<Vaccins> getUpcomingVaccin(Long childId){
        return upcomingRepository.findNextVaccin(childId);
    }
    
}
