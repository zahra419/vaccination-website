package com.example.demo.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.AllAppointmentDto;
import com.example.demo.dto.ApptRequestDto;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AllAppointmentRepository;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.ApptRequestRepository;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ApptRequestRepository apptRequestRepository;
    @Autowired
    private AllAppointmentRepository allAppointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,ApptRequestRepository apptRequestRepository,AllAppointmentRepository allAppointmentRepository){
        this.appointmentRepository=appointmentRepository;
        this.apptRequestRepository=apptRequestRepository;
        this.allAppointmentRepository=allAppointmentRepository;
    }

    public Appointment addAppointment(Appointment newAppointment){
        return appointmentRepository.save(newAppointment);
    }
    public List<ApptRequestDto> getPendingAppointment(String doctorCin){
        return apptRequestRepository.findPendingAppointment(doctorCin);
    }
    public Appointment getAppointmentById(Long id){
    return appointmentRepository.findById(id).orElse(null);
}
    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
    public List <AllAppointmentDto> getAllAppointmentsByDoctorCin(String doctorCin){
        return allAppointmentRepository.findAllAppointmentsByDoctorCin(doctorCin);
    }
    public ApptRequestDto getLatestChildAppointment(Long childId){
        return apptRequestRepository.findLatestChildAppointment(childId);
    }

}
