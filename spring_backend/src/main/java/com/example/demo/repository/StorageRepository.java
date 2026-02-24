package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Storage;  

public interface StorageRepository extends JpaRepository<Storage, Long>  {
    
}
