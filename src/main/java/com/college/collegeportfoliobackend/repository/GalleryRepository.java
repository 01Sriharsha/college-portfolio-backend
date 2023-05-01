package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Admin;
import com.college.collegeportfoliobackend.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
}
