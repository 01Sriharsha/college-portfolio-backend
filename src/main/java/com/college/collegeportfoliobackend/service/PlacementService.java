package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Faculty;
import com.college.collegeportfoliobackend.entity.Placement;
import com.college.collegeportfoliobackend.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public Placement createPlacement(Placement placement){
        return placementRepository.save(placement);
    }

    public List<Placement> getAllPlacements(){
        return placementRepository.findAll();
    }

    public Placement getSinglePlacement(Integer placementId){
        return placementRepository.findById(placementId)
                .orElseThrow(()->new RuntimeException("Placement not found"));
    }

    public Placement updatePlacement(Placement placement , Integer placementId){
        Placement existingPlacement = placementRepository.findById(placementId)
                .orElseThrow(() -> new RuntimeException("Placement not found"));
        existingPlacement.setStudentName(placement.getStudentName());
        existingPlacement.setBranch(placement.getBranch());
        return placementRepository.save(existingPlacement);
    }

    public void deletePlacement(Integer placementId){
        Placement placement = placementRepository.findById(placementId)
                .orElseThrow(() -> new RuntimeException("Placement not found"));
        placementRepository.delete(placement);
    }

    public void uploadPhoto(Integer placementId , MultipartFile file) throws IOException {
        Placement faculty = placementRepository.findById(placementId)
                .orElseThrow(() -> new RuntimeException("Placement not found"));
        faculty.setPhoto(file.getBytes());
    }
}
