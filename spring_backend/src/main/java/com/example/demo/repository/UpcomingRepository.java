package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vaccins;

@Repository
public interface UpcomingRepository extends JpaRepository<Vaccins, Long> {
    @Query(value = """
        SELECT *
        FROM vaccins v
        WHERE NOT EXISTS (
            SELECT 1
            FROM historique_vaccination h
            WHERE h.child_id = :childId
            AND h.vaccin_id = v.vaccin_id
        )
        ORDER BY v.month_due
        FETCH FIRST 1 ROW ONLY
        """, nativeQuery = true)
    Optional<Vaccins> findNextVaccin(@Param("childId") Long childId);
    
}





