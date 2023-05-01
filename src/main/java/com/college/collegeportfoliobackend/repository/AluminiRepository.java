package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Alumini;
import com.college.collegeportfoliobackend.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluminiRepository extends JpaRepository<Alumini, Integer> {
}
