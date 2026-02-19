package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Centers;
import com.example.demo.repository.CenterRepository;

@Service
public class CenterService {
     @Autowired
    private CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
        
    }
    public List<Centers> getCenters() {
        return centerRepository.findAll();
    }
 
    
}
