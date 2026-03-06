package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.ApptRequestDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Request;

@Repository
public interface ApptRequestRepository extends JpaRepository<Appointment,Long>{

      @Query(
        value = "SELECT a.appointment_id AS appointmentId, " +
                "c.full_name AS fullName, " +
                "c.gender AS gender, " +
                "v.vaccin_name AS vaccinName, " +
                "a.appointment_date AS appointmentDate " +
                "FROM appointment a " +
                "JOIN child c ON a.child_id = c.child_id " +
                "JOIN vaccins v ON a.vaccin_id = v.vaccin_id " +
                "JOIN users u ON a.doctor_cin = u.cin " +
                "WHERE a.status = 'pending' AND u.cin = :doctorCin",
        nativeQuery = true
    )
  
    List<ApptRequestDto> findPendingAppointment(@Param("doctorCin") String doctorCin);

    @Query(
        value = "SELECT c.center_name AS centerName, " +
                "u.full_name AS fullName, " +
                "v.vaccin_name AS vaccinName, " +
                "a.appointment_date AS appointmentDate, " +
                "a.status as status " +
                "FROM appointment a " +
                "join centers c on a.center_id = c.center_id " +
                "JOIN vaccins v ON a.vaccin_id = v.vaccin_id " +
                "JOIN users u ON a.doctor_cin = u.cin " +
                "WHERE a.child_id = :childId order by a.appointment_date desc fetch first 1 rows only",
        nativeQuery = true)
    ApptRequestDto findLatestChildAppointment(@Param("childId") Long childId);
}
