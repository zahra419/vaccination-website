package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ChildDto;
import com.example.demo.repository.ChildRepository;


@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
        
    }

    public List<ChildDto> getChildrenOfUser(String cin) {
    return childRepository.findChildrenOfUser(cin);
}
}
