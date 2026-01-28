package com.growvy.repository;

import com.growvy.entity.Application;
import com.growvy.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("""
        SELECT a FROM Application a
        JOIN FETCH a.jobPost jp
        LEFT JOIN FETCH jp.jobPostTags jpt
        LEFT JOIN FETCH jpt.interest i
        WHERE a.jobSeeker = :jobSeeker
          AND a.status = 'ACCEPTED'
          AND jp.startDate >= :start
          AND jp.endDate <= :end
    """)
    List<Application> findAcceptedApplicationsWithTags(
            @Param("jobSeeker") JobSeekerProfile jobSeeker,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end
    );
}
