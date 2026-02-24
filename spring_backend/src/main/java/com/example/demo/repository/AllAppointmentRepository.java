package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.AllAppointmentDto;
import com.example.demo.model.Appointment;

@Repository
public interface AllAppointmentRepository extends JpaRepository<Appointment,Integer>{
@Query(
    value=
    "SELECT a.appointment_id As appointmentId, "+
     "c.full_name as fullName, "+
     "c.gender as gender, "+
     "v.vaccin_name as vaccinName, "+
     "a.appointment_date as appointmentDate, "+
     "a.status as status "+
     "from appointment a "+
     "join child c on a.child_id=c.child_id "+
     "join users u on a.doctor_cin=u.cin "+
     "join vaccins v on a.vaccin_id=v.vaccin_id "+
     "where a.doctor_cin=:doctorCin"
    ,nativeQuery=true
)
    List<AllAppointmentDto> findAllAppointmentsByDoctorCin(@Param("doctorCin") String doctorCin);

}