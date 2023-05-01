package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship , Integer> {
}
