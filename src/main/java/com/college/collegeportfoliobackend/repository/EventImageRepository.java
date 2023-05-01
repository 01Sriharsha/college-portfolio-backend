package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage , Integer> {
}
