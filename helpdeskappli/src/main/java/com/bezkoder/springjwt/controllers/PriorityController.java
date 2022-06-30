package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.PriorityModel;
import com.bezkoder.springjwt.services.PriorityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PriorityController {
    public PriorityServiceInterface priorityService;
    @Autowired
    public PriorityController(PriorityServiceInterface priorityService) {
        this.priorityService = priorityService;
    }
    @GetMapping("/priorities")
    public ResponseEntity<List<PriorityModel>> getAllPriorities(){
        List<PriorityModel> priorities= priorityService.findAllPriorities();
        return new ResponseEntity<>(priorities, HttpStatus.OK);
    }
    @GetMapping("/priorities/{id}")
    public ResponseEntity<PriorityModel> getPriorityById(@PathVariable Long id){
        PriorityModel priority =priorityService.findPriorityById(id);
        return new ResponseEntity<>(priority, HttpStatus.OK);

    }
    @PostMapping("/priorities")
    public ResponseEntity<PriorityModel> createPriority(@RequestBody PriorityModel priorityModel){
        PriorityModel priority=priorityService.AddPriority(priorityModel);
        return new ResponseEntity<>(priority,HttpStatus.OK);
    }

    @DeleteMapping("/priorities/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePriority(@PathVariable Long id){
        Map<String,Boolean> response=priorityService.deletePriority(id);
        return  ResponseEntity.ok(response);
    }
}
