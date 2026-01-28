package com.growvy.repository;

import com.growvy.entity.JobPost;
import com.growvy.entity.JobSeekerProfile;
import com.growvy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    // 최신 공고 가져오기
    @Query("""
    SELECT DISTINCT jp
    FROM JobPost jp
    LEFT JOIN jp.jobPostTags jpt
    LEFT JOIN jpt.interest i
    WHERE jp.status = :status
      AND jp.id NOT IN (
          SELECT a.jobPost.id
          FROM Application a
          WHERE a.jobSeeker = :jobSeeker
      )
    ORDER BY jp.createdAt DESC
""")
    List<JobPost> findNewestOpenPostsByJobSeeker(
            @Param("jobSeeker") JobSeekerProfile jobSeeker,
            @Param("status") JobPost.Status status
    );
}
