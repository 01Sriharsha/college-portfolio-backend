package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Department;
import com.college.collegeportfoliobackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.createDepartment(department) , HttpStatus.CREATED);
    }

    @GetMapping("/department")
    public ResponseEntity<?> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments() , HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<?> getSingleDepartment(@PathVariable Integer departmentId){
        return new ResponseEntity<>(departmentService.getSingleDepartment(departmentId) , HttpStatus.OK);
    }

    @PutMapping("/department/{departmentId}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer departmentId , @RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartment(departmentId , department) , HttpStatus.CREATED);
    }

    @DeleteMapping("/department/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department removed successfully!!" , HttpStatus.OK);
    }
}
