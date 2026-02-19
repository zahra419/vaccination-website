
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HistoryDto;
import com.example.demo.repository.HistoryRepository;
import com.example.demo.repository.SearchVaccinHistoryRepository;

@Service
public class SearchService {

        @Autowired
    private SearchVaccinHistoryRepository searchVaccinHistoryRepository;

    public SearchService(SearchVaccinHistoryRepository searchVaccinHistoryRepository) {
        this.searchVaccinHistoryRepository = searchVaccinHistoryRepository;
        
    }

    public List<HistoryDto> getVaccinationHistory(String fullName) {
        List<HistoryDto> list = searchVaccinHistoryRepository.findVaccinationHistory(fullName);
        System.out.println("Found " + list.size() + " records");
        return list;
    //return searchVaccinHistoryRepository.findVaccinationHistory(fullName);
}
    
}
