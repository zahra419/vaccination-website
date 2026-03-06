package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Monitoring;
import com.example.demo.model.Storage;
import com.example.demo.service.MonitoringService;
import java.util.List;



@RestController
@RequestMapping("/api/dba")
public class  DbaController {

    private final MonitoringService monitoringService;

    public DbaController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }
 

    @GetMapping("/tablespaces")
    public List<Monitoring> getMonitoringData() {
        System.out.println("Received request for monitoring data");
    	return monitoringService.getMonitoringData();	
    }
    @GetMapping("/storage")
    public List<Storage> getStorageData() {
        System.out.println("Received request for storage data");
        return monitoringService.getStorageData();	
    }
    

}