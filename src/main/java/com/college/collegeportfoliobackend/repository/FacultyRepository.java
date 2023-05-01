package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty , String> {

    List<Faculty> findByDepartmentId(Integer departmentId);
}
