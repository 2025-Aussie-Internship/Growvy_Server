package com.growvy.repository;

import com.growvy.entity.JobSeekerInterest;
import com.growvy.entity.JobSeekerInterestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerInterestRepository extends JpaRepository<JobSeekerInterest, JobSeekerInterestId> {
}
