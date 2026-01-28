package com.growvy.service;

import com.growvy.dto.res.JobPostResponse;
import com.growvy.entity.Application;
import com.growvy.entity.JobPost;
import com.growvy.entity.JobSeekerProfile;
import com.growvy.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final ApplicationRepository applicationRepository;

    public List<JobPostResponse> getAcceptedPosts(JobSeekerProfile jobSeeker, LocalDate start, LocalDate end) {

        // 기본값 처리
        if (start == null) start = LocalDate.now();
        if (end == null) end = LocalDate.now();

        List<Application> applications = applicationRepository.findAcceptedApplicationsWithTags(jobSeeker, start, end);

        return applications.stream().map(a -> {
            JobPost jp = a.getJobPost();

            List<String> tags = jp.getJobPostTags().stream()
                    .map(jpt -> jpt.getInterest().getName())
                    .collect(Collectors.toList());

            JobPostResponse dto = new JobPostResponse();
            dto.setTitle(jp.getTitle());
            dto.setCompanyName(jp.getCompanyName());
            dto.setStartTime(jp.getStartTime());
            dto.setEndTime(jp.getEndTime());
            dto.setTags(tags);

            return dto;
        }).collect(Collectors.toList());
    }
}
