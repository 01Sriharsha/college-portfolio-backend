package com.college.collegeportfoliobackend.service;

import com.college.collegeportfoliobackend.entity.Course;
import com.college.collegeportfoliobackend.entity.Faculty;
import com.college.collegeportfoliobackend.repository.CourseRepository;
import com.college.collegeportfoliobackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public Course createCourse(String  facultyId, Course course) {
        Faculty faculty = facultyRepository.findById(facultyId)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        course.setFaculty(faculty);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getAllCoursesByFaculty(String facultyId){
        return courseRepository.findByFacultyId(facultyId);
    }

    public Course getSingleCourse(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Integer courseId, Course course) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        existingCourse.setName(course.getName());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }
}
