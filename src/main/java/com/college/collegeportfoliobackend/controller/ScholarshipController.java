package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Scholarship;
import com.college.collegeportfoliobackend.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class ScholarshipController {

    @Autowired
    private ScholarshipService scholarshipService;

    @PostMapping("/scholarship")
    public ResponseEntity<?> createScholarship(@RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.createScholarship(scholarship), HttpStatus.CREATED);
    }

    @GetMapping("/scholarship")
    public ResponseEntity<?> getAllScholarships() {
        return new ResponseEntity<>(scholarshipService.getAllScholarships(), HttpStatus.OK);
    }

    @GetMapping("/scholarship/{scholarshipId}")
    public ResponseEntity<?> getSingleScholarship(@PathVariable Integer scholarshipId) {
        return new ResponseEntity<>(scholarshipService.getSingleScholarship(scholarshipId), HttpStatus.OK);
    }

    @PutMapping("/scholarship/{scholarshipId}")
    public ResponseEntity<?> updateScholarship(@PathVariable Integer scholarshipId, @RequestBody Scholarship scholarship) {
        return new ResponseEntity<>(scholarshipService.updateScholarship(scholarship, scholarshipId), HttpStatus.CREATED);
    }

    @DeleteMapping("/scholarship/{scholarshipId}")
    public ResponseEntity<?> deleteScholarship(@PathVariable Integer scholarshipId) {
        scholarshipService.deleteScholarship(scholarshipId);
        return new ResponseEntity<>("Scholarship removed successfully!!", HttpStatus.OK);
    }
}
