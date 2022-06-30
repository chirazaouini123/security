package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Exceptions.ResourcesNotFoundException;
import com.bezkoder.springjwt.models.PriorityModel;
import com.bezkoder.springjwt.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PriorityServiceImpl implements  PriorityServiceInterface{
    private PriorityRepository priorityRepository;
    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public List<PriorityModel> findAllPriorities() {
        return priorityRepository.findAll();
    }

    @Override
    public PriorityModel AddPriority(PriorityModel priorityModel) {
        return priorityRepository.save(priorityModel);
    }

    @Override
    public PriorityModel findPriorityById(Long id) {
        return priorityRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("category doesn't exist with id:"+ id));
    }



    @Override
    public Map<String, Boolean> deletePriority(Long id) {
        PriorityModel priority=findPriorityById(id);
        priorityRepository.delete(priority);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
