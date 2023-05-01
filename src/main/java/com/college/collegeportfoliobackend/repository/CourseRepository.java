package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course , Integer> {

    List<Course> findByFacultyId(String facultyId);
}
