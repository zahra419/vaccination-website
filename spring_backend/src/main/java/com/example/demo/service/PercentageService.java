package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.VaccinRepository;

@Service
public class PercentageService {
    @Autowired
    private VaccinRepository vaccinRepository;

    @Autowired
    private HistoryRepository historyRepository;

    public PercentageService(HistoryRepository historyRepository) {
        this.vaccinRepository = vaccinRepository;
        this.historyRepository = historyRepository;
    }

    public double getVaccinationPercentage(Long childId) {
        long totalVaccins = vaccinRepository.count();
        long doneVaccins = historyRepository.countByChild_ChildId(childId);

        if (totalVaccins == 0) return 0;

        return ((double) doneVaccins / totalVaccins) * 100;
    }
}
