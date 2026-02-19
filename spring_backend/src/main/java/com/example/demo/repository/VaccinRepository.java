package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Vaccins;

@Repository
public interface VaccinRepository extends JpaRepository<Vaccins, Long> {
}
