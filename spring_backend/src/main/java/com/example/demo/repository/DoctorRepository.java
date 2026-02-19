package com.example.demo.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.DoctorDto;
import com.example.demo.model.Users;

@Repository
public interface DoctorRepository extends JpaRepository<Users,Long> {
     @Query(value = """
        SELECT u.full_name,u.cin
        FROM users u join doctor_vaccin dv 
        on u.cin=dv.doctor_cin
        where center_id=:centerId
        """, nativeQuery = true)
    List<Object[]> findByCenterId(@Param("centerId") Long centerId);
    
}
