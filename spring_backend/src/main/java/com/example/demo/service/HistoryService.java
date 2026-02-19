package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HistoryDto;
import com.example.demo.repository.HistoryRepository;

@Service
public class HistoryService {

        @Autowired
    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        
    }

    public List<HistoryDto> getVaccinationHistory(Long childId) {
    return historyRepository.findVaccinationHistory(childId);
}
    
}
