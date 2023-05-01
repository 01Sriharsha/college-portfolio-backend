package com.college.collegeportfoliobackend.controller;

import com.college.collegeportfoliobackend.entity.Course;
import com.college.collegeportfoliobackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/course/{facultyId}")
    public ResponseEntity<?> createCourse(
            @RequestBody Course course,
            @PathVariable String facultyId
    ) {
        return new ResponseEntity<>(courseService.createCourse(facultyId, course), HttpStatus.CREATED);
    }

    @GetMapping("/course")
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/course/{facultyId}")
    public ResponseEntity<?> getAllCoursesByFaculty(@PathVariable String facultyId){
    return new ResponseEntity<>(courseService.getAllCoursesByFaculty(facultyId), HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<?> getSingleCourse(@PathVariable Integer courseId) {
        return new ResponseEntity<>(courseService.getSingleCourse(courseId), HttpStatus.OK);
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer courseId, @RequestBody Course course) {
        return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.CREATED);
    }

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId) {
        courseService.deleteCourse(courseId);
        return new ResponseEntity<>("Course removed successfully!!", HttpStatus.OK);
    }
}