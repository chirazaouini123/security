package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.Exceptions.ResourcesNotFoundException;
import com.bezkoder.springjwt.models.StatusModel;
import com.bezkoder.springjwt.repository.StatusReposiotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatusServiceImpl implements StatusServiceInterface{
    private StatusReposiotry statusRepository;
    @Autowired
    public StatusServiceImpl(StatusReposiotry statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusModel> findAllStatus() {
        return statusRepository.findAll();
    }

    @Override
    public StatusModel AddStatus(StatusModel statusModel) {
        return statusRepository.save(statusModel);
    }



    @Override
    public StatusModel findStatusById(Long id) {
        return statusRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("category doesn't exist with id:"+ id));
    }

    @Override
    public StatusModel updateStatus(Long id, StatusModel statusModel) {
        StatusModel category=findStatusById(id);
        statusModel.setTitle(statusModel.getTitle());
        return  statusRepository.save(statusModel);    }

    @Override
    public Map<String, Boolean> deleteStatus(Long id) {
        StatusModel agent=findStatusById(id);
        statusRepository.delete(agent);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
