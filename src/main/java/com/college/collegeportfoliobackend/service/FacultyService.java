package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Department;
import com.college.collegeportfoliobackend.entity.Faculty;
import com.college.collegeportfoliobackend.repository.DepartmentRepository;
import com.college.collegeportfoliobackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Faculty createFaculty(Integer departmentId , Faculty faculty) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        String randomString = UUID.randomUUID().toString().split("-")[0];
        faculty.setId(randomString);
        faculty.setDepartment(department);
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getAllFacultiesByDepartment(Integer departmentId) {
        return facultyRepository.findByDepartmentId(departmentId);
    }

    public Faculty getSingleFaculty(String facultyId) {
        return facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public Faculty updateFaculty(String facultyId, Faculty faculty) {
        Faculty existingFaculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        existingFaculty.setName(faculty.getName());
        existingFaculty.setDesignation(faculty.getDesignation());
        existingFaculty.setQualification(faculty.getQualification());
        return facultyRepository.save(existingFaculty);
    }

    public void deleteFaculty(String facultyId) {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        facultyRepository.delete(faculty);
    }

    public void uploadPhoto(String facultyId , MultipartFile file) throws IOException {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        faculty.setPhoto(file.getBytes());
    }
}
