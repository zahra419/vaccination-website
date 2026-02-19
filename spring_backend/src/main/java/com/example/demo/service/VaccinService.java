package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vaccins;
import com.example.demo.repository.VaccinRepository;

@Service
public class VaccinService {
     @Autowired
    private VaccinRepository vaccinRepository;

    public VaccinService(VaccinRepository vaccinRepository) {
        this.vaccinRepository = vaccinRepository;
        
    }
    public List<Vaccins> getVaccins() {
        return vaccinRepository.findAll();
    }
    public Vaccins addVaccin(Vaccins newVaccin){
        return vaccinRepository.save(newVaccin);
    }
    
}
