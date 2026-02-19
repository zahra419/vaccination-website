package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.HistoryDto;
import com.example.demo.model.HistoryVaccination;



@Repository
public interface SearchVaccinHistoryRepository extends JpaRepository<HistoryVaccination, Long> {

    
      @Query("""
            
        SELECT new com.example.demo.dto.HistoryDto(
            h.vaccins.vaccinName,
            h.center.centerName,
            h.doctorCin.fullName,
            h.vaccinationDate
        )
        FROM HistoryVaccination h
        WHERE h.child.fullName = :fullName
    """)
    List<HistoryDto> findVaccinationHistory(@RequestParam("fullName") String fullName);
}