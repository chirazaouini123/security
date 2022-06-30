package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.PriorityModel;

import java.util.List;
import java.util.Map;

public interface PriorityServiceInterface {
    public List<PriorityModel> findAllPriorities();
    public PriorityModel AddPriority( PriorityModel priorityModel);
    public PriorityModel findPriorityById( Long id);

    public Map<String,Boolean> deletePriority(Long id);

}
