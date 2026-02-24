package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.model.Monitoring;
import com.example.demo.model.Storage;
import com.example.demo.repository.MonitoringRepository;
import com.example.demo.repository.StorageRepository;

import java.util.List;


@Service
public class MonitoringService {
    private final MonitoringRepository monitoringRepository;
    private final StorageRepository storageRepository;

    public MonitoringService(MonitoringRepository monitoringRepository, StorageRepository storageRepository) {
        this.monitoringRepository = monitoringRepository;
        this.storageRepository = storageRepository;
    }

    public List<Monitoring> getMonitoringData() {
        return monitoringRepository.findAll();
    }
    public List<Storage> getStorageData() {
        return storageRepository.findAll();
    }
}