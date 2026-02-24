package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Monitoring;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface MonitoringRepository extends JpaRepository<Monitoring, Long> {
   
}