package com.rajeeb.studentpractice.service;

import com.rajeeb.studentpractice.entity.Parent;
import com.rajeeb.studentpractice.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {
    @Autowired
    private ParentRepository parentRepository;

    public List<Parent> getAllParents(Parent parent) {
       return parentRepository.findAll();
    }

    public Parent insertParentDetails(Parent parent) {
          return parentRepository.save(parent);
    }

    public void deleteParentById(Long p_id) {
        parentRepository.deleteById(p_id);
    }

    public Parent updateParentById(Parent parent) {
        return parentRepository.save(parent);
    }
}
