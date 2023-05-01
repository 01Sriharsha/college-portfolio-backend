package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Placement;
import com.college.collegeportfoliobackend.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {
}
