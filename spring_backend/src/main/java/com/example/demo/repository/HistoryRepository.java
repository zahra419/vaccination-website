package com.example.demo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.HistoryDto;
import com.example.demo.model.HistoryVaccination;

import oracle.net.aso.h;


@Repository
public interface HistoryRepository extends JpaRepository<HistoryVaccination, Long> {

    // Custom query to fetch only the fields needed for login
  /*  @Query("SELECT new com.example.demo.dto.HistoriqueDto(v.vaccin_name, c.center_name , u.full_name ,h.vaccinationDate ) " +
       "FROM HistoriqueVaccination h JOIN vaccins v on h.vaccin_id=v.vaccin_id join centers c on h.center_id=c.center_id join Users u join h.cin=u.cin" +"WHERE ch.child_id = :child_id")
    Optional<HistoriqueDto> findVaccinHistorique(@Param("childId") Long childId);*/

   /*  @Query("SELECT new com.example.demo.dto.HistoriqueDto(v.vaccinName, c.centerName , u.full_name ,h.vaccinationDate ) " +
       "FROM HistoryVaccination h join center c join vaccins v join userDoctor u join child ch" +"WHERE ch.child_id = :child_id")*/
    
      @Query("""
            
        SELECT new com.example.demo.dto.HistoryDto(
            h.vaccins.vaccinName,
            h.center.centerName,
            h.doctorCin.fullName,
            h.vaccinationDate
        )
        FROM HistoryVaccination h
        WHERE h.child.childId = :childId
    """)
    List<HistoryDto> findVaccinationHistory(@Param("childId") Long childId);

    long countByChild_ChildId(Long childId);
}
