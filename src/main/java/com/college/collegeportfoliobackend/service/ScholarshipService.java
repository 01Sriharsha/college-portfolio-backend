package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Scholarship;
import com.college.collegeportfoliobackend.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScholarshipService {

    @Autowired
    private ScholarshipRepository scholarshipRepository;

    public Scholarship createScholarship(Scholarship scholarship){
        return scholarshipRepository.save(scholarship);
    }

    public List<Scholarship> getAllScholarships(){
        return scholarshipRepository.findAll();
    }

    public Scholarship getSingleScholarship(Integer scholarshipId){
        return scholarshipRepository.findById(scholarshipId)
                .orElseThrow(()->new RuntimeException("Scholarship not found"));
    }

    public Scholarship updateScholarship(Scholarship scholarship , Integer scholarshipId){
        Scholarship existingScholarship = scholarshipRepository.findById(scholarshipId)
                .orElseThrow(() -> new RuntimeException("Scholarship not found"));
        existingScholarship.setName(scholarship.getName());
        existingScholarship.setStartDate(scholarship.getStartDate());
        existingScholarship.setEndDate(scholarship.getEndDate());
        return scholarshipRepository.save(existingScholarship);
    }

    public void deleteScholarship(Integer scholarshipId){
        Scholarship scholarship = scholarshipRepository.findById(scholarshipId)
                .orElseThrow(() -> new RuntimeException("Scholarship not found"));
        scholarshipRepository.delete(scholarship);
    }
}
