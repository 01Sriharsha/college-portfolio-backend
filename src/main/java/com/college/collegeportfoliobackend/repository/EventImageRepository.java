package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventImageRepository extends JpaRepository<EventImage , Integer> {


    List<EventImage> findByEventId(Integer eventId);
}
