package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Faculty;
import com.college.collegeportfoliobackend.service.FacultyService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/faculty/{departmentId}")
    public ResponseEntity<?> createFaculty(@RequestBody Faculty faculty, @PathVariable Integer departmentId) {
        return new ResponseEntity<>(facultyService.createFaculty(departmentId, faculty), HttpStatus.CREATED);
    }

    @GetMapping("/faculty")
    public ResponseEntity<?> getAllFaculties() {
        return new ResponseEntity<>(facultyService.getAllFaculties(), HttpStatus.OK);
    }

    @GetMapping("/faculty/{departmentId}")
    public ResponseEntity<?> getAllFacultiesByDepartment(@PathVariable Integer departmentId) {
        return new ResponseEntity<>(facultyService.getAllFacultiesByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<?> getSingleFaculty(@PathVariable String facultyId) {
        return new ResponseEntity<>(facultyService.getSingleFaculty(facultyId), HttpStatus.OK);
    }

    @PutMapping("/faculty/{facultyId}")
    public ResponseEntity<?> updateFaculty(@PathVariable String facultyId, @RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultyService.updateFaculty(facultyId, faculty), HttpStatus.CREATED);
    }

    @DeleteMapping("/faculty/{facultyId}")
    public ResponseEntity<?> deleteFaculty(@PathVariable String facultyId) {
        facultyService.deleteFaculty(facultyId);
        return new ResponseEntity<>("Faculty removed successfully!!", HttpStatus.OK);
    }

    @PostMapping("/faculty/{facultyId}/upload")
    public ResponseEntity<?> uploadPhoto(@PathVariable String facultyId , @RequestParam("image") MultipartFile image) throws IOException {
        facultyService.uploadPhoto(facultyId , image);
        return new ResponseEntity<>("Photo Uploaded successfully" , HttpStatus.OK);
    }

    @GetMapping("/faculty/{facultyId}/download")
    public ResponseEntity<?> downloadPhoto(@PathVariable String facultyId , HttpServletResponse response) throws IOException {
        Faculty faculty = facultyService.getSingleFaculty(facultyId);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(faculty.getPhoto());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(inputStream , response.getOutputStream());
        return new ResponseEntity<>("success" , HttpStatus.OK);
    }
}
