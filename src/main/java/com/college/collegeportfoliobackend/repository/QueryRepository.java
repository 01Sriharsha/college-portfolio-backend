package com.college.collegeportfoliobackend.repository;

import com.college.collegeportfoliobackend.entity.Admin;
import com.college.collegeportfoliobackend.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer> {
}
