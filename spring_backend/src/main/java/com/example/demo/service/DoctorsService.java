package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDto;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorsService {
    private DoctorRepository doctorRepository;
    @Autowired
    public DoctorsService(DoctorRepository doctorRepository){
          this.doctorRepository=doctorRepository;
    }
    public List<DoctorDto> getDoctorsOfCenter(Long selectedCenter){
        //return doctorRepository.findByCenterId(selectedCenter);
        return doctorRepository.findByCenterId(selectedCenter)
                .stream()
                .map(arr -> new DoctorDto((String) arr[0], (String) arr[1]))
                .collect(Collectors.toList());

    }
    
}
