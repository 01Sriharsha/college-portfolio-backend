package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event , Integer> {
}
